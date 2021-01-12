package Model;

import javafx.scene.image.Image;

import java.util.List;

public class CheckingAccount extends Account{

    private List<Check> checksUsed;

    CheckingAccount(Customer originalOwner, double balance) {
        super(originalOwner, balance);
    }

    private class Check{
        public int CheckNum;
        public int checkImgId;
        public Image checkImg;

        public Check(int checkNum, int checkImgId, Image checkImg){
            this.checkImg = checkImg;
            this.CheckNum = checkNum;
            this.checkImgId = checkImgId;
        }
    }

    public List<Check> getChecksUsed(){
        return checksUsed;
    }

    public void addNewCheckUsed(Check checkToAdd){
        checksUsed.add(checkToAdd);
    }
}
