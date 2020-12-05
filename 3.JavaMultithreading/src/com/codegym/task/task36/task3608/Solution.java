package com.codegym.task.task36.task3608;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.MainModel;
import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.view.EditUserView;
import com.codegym.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        //emulate user events
        usersView.fireShowAllUsersEvent();
        System.out.println();
        usersView.fireOpenUserEditFormEvent(126L);
        System.out.println();
        editUserView.fireUserDeletedEvent(124L);
        System.out.println();
        editUserView.fireUserDataChangedEvent("Marek", 123, 5);
        System.out.println();
        usersView.fireShowDeletedUsersEvent();
    }
}