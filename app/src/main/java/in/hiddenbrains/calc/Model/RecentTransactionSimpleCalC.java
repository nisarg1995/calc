package in.hiddenbrains.calc.Model;

public class RecentTransactionSimpleCalC {
    int id;
    String evaluationString;
    String answer;

    public RecentTransactionSimpleCalC(int id ,String evaluationString , String answer){
        this.id = id;
        this.evaluationString = evaluationString;
        this.answer = answer;
    }

    public RecentTransactionSimpleCalC(){

    }

    public RecentTransactionSimpleCalC(int id){
        this.id = id;
    }

    public RecentTransactionSimpleCalC(String evaluationString , String answer) {
        this.evaluationString = evaluationString;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluationString() {
        return evaluationString;
    }

    public void setEvaluationString(String evaluationString) {
        this.evaluationString = evaluationString;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
