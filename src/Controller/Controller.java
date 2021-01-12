package Controller;

import View.AppView;
import View.UIUserCreate;

public class Controller {

    private AppView view;

    public Controller(AppView view){
        this.view = view;
    }

    public void shutDown(){
        if (view.confirmExit()){
            System.exit(0);
        }
    }

    public void userCreate(){
        UIUserCreate uiUserCreate = new UIUserCreate();
        uiUserCreate.createPane();
    }
}
