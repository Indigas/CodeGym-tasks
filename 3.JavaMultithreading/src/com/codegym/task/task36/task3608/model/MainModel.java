package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.model.service.UserService;
import com.codegym.task.task36.task3608.model.service.UserServiceImpl;

import java.util.Iterator;
import java.util.List;

public class MainModel implements Model {
    private DataModel dataModel = new DataModel();
    private UserService userService = new UserServiceImpl();

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {

        dataModel.setDisplayDeletedUserList(false);
        dataModel.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        dataModel.setDisplayDeletedUserList(true);
        dataModel.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        dataModel.setActiveUser(userService.getUsersById(userId));
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        List<User> users = getAllUsers();
        //refresh model data
        dataModel.setUsers(users);
    }

    private List<User> getAllUsers(){
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        dataModel.setUsers(getAllUsers());
    }
}
