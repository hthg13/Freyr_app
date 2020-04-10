package com.example.client.data.Repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.client.data.DAO.UserDao;
import com.example.client.data.DB.UserDatabase;
import com.example.client.data.entities.User;

import java.util.List;

public class UserRepository {

    private MutableLiveData<List<User>> searchResults =
            new MutableLiveData<>();

    private void asyncFinished(List<User> results) {
        searchResults.setValue(results);
    }

    private UserDao mUserDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase db;
        db = UserDatabase.getInstance(application);
        mUserDao = db.mUserDao();
        allUsers = mUserDao.getAllUsers();
    }

    public void insertUser(User newUser) {
        InsertAsyncTask task = new InsertAsyncTask(mUserDao);
        task.execute(newUser);
    }

    public void deleteUser(String username) {
        DeleteAsyncTask task = new DeleteAsyncTask(mUserDao);
        task.execute(username);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    //todo more methods that call the asinc methods below


    /**
     * Query to database
     */
    private static class QueryAsyncTask extends AsyncTask<String, Void, List<User>> {

        private UserDao mUserDao;
        private UserRepository mUserRepository = null;

        // todo how to = https://www.techotopia.com/index.php/An_Android_Room_Database_and_Repository_Tutorial

        QueryAsyncTask(UserDao dao){
            mUserDao = dao;
        }

        @Override
        protected List<User> doInBackground(final String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(List<User> result){
            mUserRepository.asyncFinished(result);
        }
    }

    /**
     * Insert to database
     */
    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        InsertAsyncTask(UserDao dao) {
            mUserDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mUserDao.insertUser(params[0]);
            return null;
        }
    }

    /**
     * Delete from database
     */
    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {
        private UserDao mUserDao;

        DeleteAsyncTask(UserDao dao) {
            mUserDao = dao;
        }

        @Override
        protected Void doInBackground(String... params) {
            mUserDao.deleteUser(params[0]);
            return null;
        }
    }



    /*
    private UserDao mUserDao;
    private static volatile UserRepository instance;
    private User user = null;
    private UserDatabase userDataSource;

    public void insertUser(User user) {
        new UserInsertion(mUserDao).execute(user);
    }

    private static class UserInsertion extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        private UserInsertion(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            // hér getur verið deleteAlldata til þess að hreinsa úr töflu áður en sett er inn í hana
            //mUserDao.insertUser(user[0]);
            Log.d("helga: ", String.valueOf(user[0]));
            return null;
        }
    }

     */
}


