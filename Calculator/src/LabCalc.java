import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabCalc extends JFrame implements ActionListener{ 
 
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  //OS check
  private static String OS = System.getProperty("os.name").toLowerCase();
 


  JTextField result = new JTextField(); 
  
  String value;
  double number;
  double total = 0;
  double previous = 0;
  double using = -1;
  int operation = 0;
  boolean equalsPressed = false;
  
  public LabCalc() {
   
  //Menu  
    if(isWindows()){
      JMenuBar topBar = new JMenuBar();
        this.setJMenuBar(topBar);
        JMenu file = new JMenu("File");
          topBar.add(file);
              JMenuItem close = new JMenuItem("Close");
                file.add(close);
              close.addActionListener(this);
              close.setActionCommand("close");
    } else if (isMac()){
      
    }
    this.setTitle("Gustavo's Calculator");
    this.setVisible(true);
    this.setSize(300,400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Grid Layout being used
    this.setLayout(new GridLayout(8,1));
    
    //Results/typing field
    this.add(result);
    
    //Panel for memory buttons
    JPanel memory = new JPanel();
      memory.setLayout(new GridLayout(1,6));
      JButton mc = new JButton("MC");
        memory.add(mc);
        mc.addActionListener(this);
        mc.setActionCommand("mc");    
      JButton mr = new JButton("MR");
        memory.add(mr);
        mr.addActionListener(this);
        mr.setActionCommand("mr");  
      JButton mplus = new JButton("M+");
        memory.add(mplus);
        mplus.addActionListener(this);
        mplus.setActionCommand("mplus");   
      JButton mminus = new JButton("M-");
        memory.add(mminus);
        mminus.addActionListener(this);
        mminus.setActionCommand("mminus");    
      JButton ms = new JButton("MS");
        memory.add(ms);
        ms.addActionListener(this);
        ms.setActionCommand("ms");     
      JButton mstar = new JButton("M*");
        memory.add(mstar);   
        mstar.addActionListener(this);
        mstar.setActionCommand("mstar");
    this.add(memory);
    
    //Panel for numbers
    JPanel digits = new JPanel();
    digits.setLayout(new GridLayout(1,4));
      JButton percent = new JButton("%");
        digits.add(percent);
        percent.addActionListener(this);
        percent.setActionCommand("percent");    
      JButton sqrt = new JButton("sqrt");
        digits.add(sqrt);
        sqrt.addActionListener(this);
        sqrt.setActionCommand("sqrt");     
      JButton square = new JButton("^2");
        digits.add(square);
        square.addActionListener(this);
        square.setActionCommand("square");   
      JButton underx = new JButton("1/x");
        underx.addActionListener(this);
        underx.setActionCommand("underx");
        digits.add(underx);
     this.add(digits);
     
   JPanel digits2 = new JPanel();
   digits2.setLayout(new GridLayout(1,4));
      JButton ce = new JButton("CE");
        digits2.add(ce);
        ce.addActionListener(this);
        ce.setActionCommand("ce"); 
      JButton c = new JButton("C");
        digits2.add(c);
        c.addActionListener(this);
        c.setActionCommand("c");
      JButton back = new JButton("<-");
        digits2.add(back);
        back.addActionListener(this);
        back.setActionCommand("back");
      JButton divide = new JButton("/");
        digits2.add(divide);
        divide.addActionListener(this);
        divide.setActionCommand("divide");
   this.add(digits2);
   
   JPanel digits3 = new JPanel();
   digits3.setLayout(new GridLayout(1,4));
      JButton seven = new JButton("7");
        digits3.add(seven);
        seven.addActionListener(this);
        seven.setActionCommand("seven");
      JButton eight = new JButton("8");
        digits3.add(eight);
        eight.addActionListener(this);
        eight.setActionCommand("eight");
      JButton nine = new JButton("9");
        digits3.add(nine);
        nine.addActionListener(this);
        nine.setActionCommand("nine");
      JButton times = new JButton("X");
        digits3.add(times);
        times.addActionListener(this);
        times.setActionCommand("times");
   this.add(digits3);     
   
   JPanel digits4 = new JPanel();
    digits4.setLayout(new GridLayout(1,4));
    JButton four = new JButton("4");
      digits4.add(four);
      four.addActionListener(this);
      four.setActionCommand("four");
    JButton five = new JButton("5");
      digits4.add(five);
      five.addActionListener(this);
      five.setActionCommand("five");
    JButton six = new JButton("6");
      digits4.add(six);
      six.addActionListener(this);
      six.setActionCommand("six");
    JButton minus = new JButton("-");
      digits4.add(minus);
      minus.addActionListener(this);
      minus.setActionCommand("minus");
  this.add(digits4);      
        
  JPanel digits5 = new JPanel();
    digits5.setLayout(new GridLayout(1,4));
    JButton one = new JButton("1");
      one.addActionListener(this);
      one.setActionCommand("one");
      digits5.add(one);
    JButton two = new JButton("2");
      digits5.add(two);
      two.addActionListener(this);
      two.setActionCommand("two");
    JButton three = new JButton("3");
      digits5.add(three);
      three.addActionListener(this);
      three.setActionCommand("three");
    JButton plus = new JButton("+");
      digits5.add(plus);
      plus.addActionListener(this);
      plus.setActionCommand("plus");
  this.add(digits5);
  
  JPanel digits6 = new JPanel();
  digits6.setLayout(new GridLayout(1,4));
      JButton minusplus = new JButton("+/-");
        digits6.add(minusplus);
        minusplus.addActionListener(this);
        minusplus.setActionCommand("minusplus");    
      JButton zero = new JButton("0");
        digits6.add(zero);
        zero.addActionListener(this);
        zero.setActionCommand("zero");
      JButton dot = new JButton(".");
        digits6.add(dot);
        dot.addActionListener(this);
        dot.setActionCommand("dot");    
      JButton igual = new JButton("=");
        digits6.add(igual);
        igual.addActionListener(this);
        igual.setActionCommand("igual");    
  this.add(digits6);

    validate();
    repaint();
  }

  public static void main(String[] args) {
    new LabCalc();
  }
  
  public static boolean isWindows(){
    return (OS.indexOf("win") >= 0);
  }

  public static boolean isMac() {
    return (OS.indexOf("mac") >= 0);
  }
  
  public static String getOS(){
    if (isWindows()) {
        return "win";
    } else if (isMac()) {
        return "osx";
    } else {
        return "err";
    }
  }

  public void keyPressed(KeyEvent e) {

    int keyCode = e.getKeyCode();
          switch( keyCode ) {

       case KeyEvent.VK_0:
           clickZero();
           break;
       case KeyEvent.VK_1:
           clickOne();
           break;
       case KeyEvent.VK_2:
           clickTwo();
           break;
       case KeyEvent.VK_3 :
           clickThree();
           break;
       case KeyEvent.VK_4 :
         clickFour();
         break;
       case KeyEvent.VK_5 :
         clickFive();
         break;
       case KeyEvent.VK_6 :
         clickSix();
         break;
       case KeyEvent.VK_7 :
         clickSeven();
         break;
       case KeyEvent.VK_8 :
         clickEight();
         break;
       case KeyEvent.VK_9 :
         clickNine();
         break;
       case KeyEvent.VK_PLUS:
         clickPlus();
         break;
       case KeyEvent.VK_MINUS:
         clickMinus();
         break;
       case KeyEvent.VK_MULTIPLY:
         clickTimes();
         break;
       case KeyEvent.VK_DIVIDE:
         clickDivide();
         break;
       case KeyEvent.VK_EQUALS:
         clickEquals();
         break;
     }
    }
  
  public void clickEquals(){
    equalsPressed = true;
    switch (operation){
    case 0:
      break;
    case 1:
      total = previous + doubleResult();
      break;
    case 2:
      total = previous - doubleResult();
      break;
    case 3:
      total = previous * doubleResult();
      break;
    case 4:
      total = previous / doubleResult();
      break;
    default:
      result.setText("Operation out of range!");
      System.out.println("Operation number out of range!");
    }
    displayTotal();
    setOperation(0);
    setUsing(-1);
  }

  public double doubleResult(){
    return Double.parseDouble(result.getText());
  }
  
  public void displayTotal(){
    if(total%1==0){
      result.setText(String.valueOf((int) total));
    } else {
      result.setText(String.valueOf(total));
    }
  }
  
  public void clearText(){
    result.setText("");
  }
  
  public void concatDigit(String s){
    result.setText(result.getText().concat(s));
  }
  
  public void checkOperation(){
    if (operation!=0 || equalsPressed){
      clearText();
    } 
  }
  
  public void unpressEquals(){
    equalsPressed = false;
  }
  
  public void setUsing(int e){
    using = e;
  }
  
  public void clickZero(){
    checkOperation();
    concatDigit("0");
    setUsing(0);
    unpressEquals();
  }
  
  public void clickOne(){
    checkOperation();
    concatDigit("1");
    setUsing(1);
    unpressEquals();
  }
  
  public void clickTwo(){
    checkOperation();
    concatDigit("2");
    setUsing(2);
    unpressEquals();
  }  
  
  public void clickThree(){
    checkOperation();
    concatDigit("3");
    setUsing(3);
    unpressEquals();
  }
  
  public void clickFour(){
    checkOperation();
    concatDigit("4");
    setUsing(4);
    unpressEquals();
  }
  
  public void clickFive(){
    checkOperation();
    concatDigit("5");
    setUsing(5);
    unpressEquals();
  }
  
  public void clickSix(){
    checkOperation();
    concatDigit("4");
    setUsing(4);
    unpressEquals();
  }
  
  public void clickSeven(){
    checkOperation();
    concatDigit("7");
    setUsing(7);
    unpressEquals();
  }
  
  public void clickEight(){
    checkOperation();
    concatDigit("8");
    setUsing(8);
    unpressEquals();
  }
  
  public void clickNine(){
    checkOperation();
    concatDigit("9");
    setUsing(9);
    unpressEquals();
  }
  
  public void clickPlus(){
    if(operationInUse() == false){
      setPrevious() ;
      setOperation(1);
    }
  }
  
  public void clickMinus(){
    if(operationInUse() == false){
      setPrevious() ;
      setOperation(2);
    }
  }
  
  public void clickTimes(){
    if(operationInUse() == false){
      setPrevious() ;
      setOperation(3);
    }
  }
  
  public void clickDivide(){
    if(operationInUse() == false){
      setPrevious() ;
      setOperation(4);
    }
  }
  
  public void clickC(){
    value = null;
    previous = 0;
    clearText();
    total = 0;
  }
  
  private void clickMinusPlus() {
    total *= -1;
    displayTotal();
  }
  
  public void setOperation(int e){
    operation = e;
    setUsing(-1);
  }
  
  public boolean operationInUse(){
    if (operation!=0 && using != -1){
      clickEquals();
      setOperation(0);
      return true;
    } else {
      return false;
    }
  }
  
  public void setPrevious(){
    previous = doubleResult();
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("close")){
      System.exit(0);
    } else if (e.getActionCommand().equals("igual")){
      clickEquals();
    } else if (e.getActionCommand().equals("one")){
      clickOne();
    } else if (e.getActionCommand().equals("two")){
      clickTwo();
    } else if (e.getActionCommand().equals("three")){
      clickThree();
    } else if (e.getActionCommand().equals("four")){
      clickFour();
    } else if (e.getActionCommand().equals("five")){
      clickFive();
    } else if (e.getActionCommand().equals("six")){
      clickSix();
    } else if (e.getActionCommand().equals("seven")){
      clickSeven();
    } else if (e.getActionCommand().equals("eight")){
      clickEight();
    } else if (e.getActionCommand().equals("nine")){
      clickNine();
    } else if (e.getActionCommand().equals("plus")){
      clickPlus();
    } else if (e.getActionCommand().equals("minus")){
      clickMinus();
    } else if (e.getActionCommand().equals("times")){
      clickTimes();
    } else if (e.getActionCommand().equals("divide")){
      clickDivide();
    } else if (e.getActionCommand().equals("c")){
      clickC();
    } else if (e.getActionCommand().equals("minusplus")){
      clickMinusPlus();
    }
}


}
