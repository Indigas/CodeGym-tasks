package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class UsersView implements View{
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(DataModel dataModel) {
        StringBuilder sb = dataModel.isDisplayDeletedUserList() ? new StringBuilder("All deleted users:") : new StringBuilder("All users:");
        for(User user : dataModel.getUsers()){
            sb.append("\n\t");
            sb.append(user.toString());
        }
        sb.append("\n").append("===================================================");
        System.out.print(sb.toString());
    }

    public void fireShowAllUsersEvent(){
        controller.onShowAllUsers();
    }

    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }

    public void fireOpenUserEditFormEvent(long id) {
        controller.onOpenUserEditForm(id);
    }

}
