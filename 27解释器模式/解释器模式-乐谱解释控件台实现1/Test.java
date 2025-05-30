package code.chapter27.interpreter1;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        PlayContext context = new PlayContext();
        //音乐-上海滩
        System.out.println("音乐-上海滩：");
        context.setPlayText("O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");

        Expression expression=null;    
        //System.out.println(context.getPlayText().length());
        while (context.getPlayText().length() > 0) {
            String str = context.getPlayText().substring(0, 1);
            switch (str) {
                case "O":
                    expression = new Scale();
                    break;
                case "C":
                case "D":
                case "E":
                case "F":
                case "G":
                case "A":
                case "B":
                case "P":
                    expression = new Note();
                    break;

            }
            expression.interpret(context);
        }
        
        System.out.println();
        
        System.out.println();
        System.out.println("**********************************************");
    }
}

//演奏内容
class PlayContext {
    private String playText;
    public String getPlayText(){
        return this.playText;
    }
    public void setPlayText(String value){
        this.playText = value;
    }
}

//抽象表达式类
abstract class Expression {
    
    public void interpret(PlayContext context) {
      if (context.getPlayText().length() == 0) {
          return;
      }
      else {
        String playKey = context.getPlayText().substring(0, 1);
          
        context.setPlayText(context.getPlayText().substring(2));

        double playValue = Double.parseDouble(context.getPlayText().substring(0,context.getPlayText().indexOf(" ")));
        context.setPlayText(context.getPlayText().substring(context.getPlayText().indexOf(" ") + 1));

        this.excute(playKey, playValue);
      }
    }
    //抽象方法“执行”，不同的文法子类，有不同的执行处理
    public abstract void excute(String key, double value);
}

//音符类
class Note extends Expression {
    public void excute(String key, double value) {
        String note = "";
        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
        }
        System.out.print(note+" ");
    }
}

//音阶类
class Scale extends Expression {
    public void excute(String key, double value) {
        String scale = "";
        switch ((int)value) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
        }
        System.out.print(scale+" ");
    }
}



