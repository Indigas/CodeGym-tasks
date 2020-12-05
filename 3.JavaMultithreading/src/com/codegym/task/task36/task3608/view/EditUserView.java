package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class EditUserView implements View{
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(DataModel dataModel) {
        StringBuilder sb = new StringBuilder("User to be edited:");
        sb.append("\n\t");
        sb.append(dataModel.getActiveUser().toString());
        sb.append("\n===================================================");
        System.out.print(sb.toString());
    }

    public void fireUserDeletedEvent(long id){
        controller.onDeleteUser(id);
    }

    public void fireUserDataChangedEvent(String name, long id, int level){
        controller.onChangeUserData(name, id, level);
    }
}