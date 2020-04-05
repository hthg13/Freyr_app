package com.example.client.data.Repositories;

import android.os.AsyncTask;
import com.example.client.data.DAO.UserDao;
import com.example.client.data.entities.User;

public class UserRepository {

    private UserDao mUserDao;

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
            mUserDao.insertUser(user[0]);
            return null;
        }
    }
}


