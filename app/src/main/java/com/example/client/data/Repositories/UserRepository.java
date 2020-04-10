package com.example.client.data.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.client.data.DAO.UserDao;
import com.example.client.data.DB.UserDatabase;
import com.example.client.data.entities.User;

import java.util.List;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> allUsers;
    private LiveData<Integer> mcountUsersWithName;

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

    public void deleteUser(User user) {
        DeleteAsyncTask task = new DeleteAsyncTask(mUserDao);
        task.execute(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void updateUserEmail(String email, long id) {
        String type = "updateUserEmail";

        String[] param = new String[3];

        param[0] = type;
        param[1] = email;
        param[2] = String.valueOf(id);

        QueryAsyncTask task = new QueryAsyncTask(mUserDao);
        task.execute(param);
    }

    public void updateUserCookbookId(int cookbookid, long userId) {
        String type = "updateUserCookbookId";
        reuse(type, cookbookid, userId);
    }

    public void updateUserScheduleId(int scheduleid, long userId) {
        String type = "updateUserScheduleId";
        reuse(type, scheduleid, userId);
    }

    public void updateUserShoppingListId(int shoppinglistid, long userId) {
        String type = "updateUserShoppingListId";
        reuse(type, shoppinglistid, userId);
    }

    private void reuse(String type, int objectId, long userId) {
        String[] param = new String[3];

        param[0] = type;
        param[1] = String.valueOf(objectId);
        param[2] = String.valueOf(userId);

        QueryAsyncTask task = new QueryAsyncTask(mUserDao);
        task.execute(param);
    }

    /**
     * Query to database
     */
    private static class QueryAsyncTask extends AsyncTask<String, Void, List<User>> {

        private UserDao mUserDao;
        private UserRepository mUserRepository = null;

        QueryAsyncTask(UserDao dao){
            mUserDao = dao;
        }

        @Override
        protected List<User> doInBackground(final String... params) {
            String type = params[0];

            // params[1] = email, params[2] = userId
            if (type.equals("updateUserEmail")) {
                mUserDao.updateUserEmail(params[1], Long.parseLong(params[2]));
            }

            // params[1] = CookBookId, params[2] = userId
            if (type.equals("updateUserCookbookId")) {
                mUserDao.updateUserCookbookId(Integer.parseInt(params[1]), Long.parseLong(params[2]));
            }

            // params[1] = ScheduleId, params[2] = userId
            if (type.equals("updateUserScheduleId")) {
                mUserDao.updateUserScheduleId(Integer.parseInt(params[1]), Long.parseLong(params[2]));
            }

            // params[1] = shoppingList, params[2] = userId
            if (type.equals("updateUserShoppingListId")) {
                mUserDao.updateUserShoppingListId(Integer.parseInt(params[1]), Long.parseLong(params[2]));
            }

            return null;
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
    private static class DeleteAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        DeleteAsyncTask(UserDao dao) {
            mUserDao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.deleteUser(users[0]);
            return null;
        }
    }
}


