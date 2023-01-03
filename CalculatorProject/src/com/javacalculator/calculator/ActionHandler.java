package com.javacalculator.calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles the user input of the calculator.
 * 
 * @author David Emilsson
 */
public class ActionHandler implements ActionListener {
	
	Calculator obj;
	
	/**
	 * Passing the instance of the calculator class to the ActionHandler class.
	 */
	ActionHandler(Calculator obj){
		this.obj = obj;
	}

	/**
	 * Invoked when an action occurs to perform the actions of the calculator.
	 */
	public void actionPerformed(ActionEvent e) {
	
		for(int i=0;i<10;i++) {
			if(e.getSource() == obj.numberButtons[i]) {
				obj.textField.setText(obj.textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==obj.decButton) {
			obj.textField.setText(obj.textField.getText().concat("."));
		}
		if(e.getSource()==obj.addButton) {
			obj.num1 = (Double.parseDouble(obj.textField.getText()));
			obj.operator ='+';
			obj.textField.setText("");
		}
		if(e.getSource()==obj.subButton) {
			obj.num1 = (Double.parseDouble(obj.textField.getText()));
			obj.operator ='-';
			obj.textField.setText("");
		}
		if(e.getSource()==obj.mulButton) {
			obj.num1 = (Double.parseDouble(obj.textField.getText()));
			obj.operator ='*';
			obj.textField.setText("");
		}
		if(e.getSource()==obj.divButton) {
			obj.num1 = (Double.parseDouble(obj.textField.getText()));
			obj.operator ='/';
			obj.textField.setText("");
		}
		if(e.getSource()==obj.equButton) {
			obj.num2 = (Double.parseDouble(obj.textField.getText()));
			
			boolean exceptionThrown = false;
			
			switch(obj.operator) {
			case'+':
				obj.result=obj.num1+obj.num2;
				break;
			case'-':
				obj.result=obj.num1-obj.num2;
				break;
			case'*':
				obj.result=obj.num1*obj.num2;
				break;
			case'/':
				try {
					obj.result=obj.num1/obj.num2;	
					if (obj.num2 == 0) {
						throw new ArithmeticException("Can't divide by 0");
					}
				} catch (ArithmeticException eError) {
					obj.textField.setText(eError.getMessage());
					exceptionThrown = true;
				}			
				break;
			}
			if (!exceptionThrown) {
				obj.textField.setText(String.valueOf(obj.result));
				obj.num1 = obj.result;
			}	
		}
		if(e.getSource()==obj.clrButton) {
			obj.textField.setText("");
		}
		if(e.getSource()==obj.delButton) {
			String string = obj.textField.getText();
			obj.textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				obj.textField.setText(obj.textField.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==obj.negButton) {
			double temp = Double.parseDouble(obj.textField.getText());
			temp*=-1;
			obj.textField.setText(String.valueOf(temp));
		}
	}
}
