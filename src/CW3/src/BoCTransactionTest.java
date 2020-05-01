package src;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class BoCTransactionTest {
	private String testInputString, testOutputString;
	private BigDecimal testInputBudget;
	private BigDecimal testOutputBudget;
	private BigDecimal testExceptOutputBudget;
	
	@Ignore
	void test() {
		fail("Not yet implemented");
	}

	/* 
	1 – Pass – Leo - 14:25/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest1
	*/
	@Test		
	void setNameTest1() {
		testInputString = "Leo";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testInputString, testOutputString);
	}
	
	@Test
	void setNameTest2() {
		testInputString = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testInputString, testOutputString);
	}
	
	@Test
	void setNameTest3() {
		testInputString = "QWERTYUIOPASDFGHJKLZXCVBNM";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals("QWERTYUIOPASDFGHJKLZXCVBN", testOutputString);
	}
	
	@Test
	void setValueTest1(){
		testInputBudget = new BigDecimal(123);
		testExceptOutputBudget = new BigDecimal("123");
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	
	@Test
	void setValueTest2(){
		testInputBudget = new BigDecimal("123.12");
		testExceptOutputBudget = new BigDecimal("123.12");
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	
	@Test
	void setValueTest3(){
		testInputBudget = new BigDecimal("123.123");
		testExceptOutputBudget = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	
	@Test
	void setValueTest4(){
		testInputBudget = new BigDecimal("-123.12");
		testExceptOutputBudget = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	
	@Test
	void setCatTest1(){
		int testInput = 10;
		int testExceptOutput = 10;
		int testOutput = 0;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionCategory(testInput);
			testOutput = copy.transactionCategory();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	
	@Test
	void setCatTest2(){
		int testInput = -10;
		int testExceptOutput = 0;
		int testOutput = 0;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionCategory(testInput);
			testOutput = copy.transactionCategory();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	
	@Test
	void ToStringTest1(){
		BigDecimal tValue = new BigDecimal(123);
		String testExceptOutput = null;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(tValue);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	
	@Test
	void ToStringTest2(){
		String tName = "Leo";
		String testExceptOutput = null;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(tName);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	
	@Test
	void ToStringTest3(){
		String tName = "Leo";
		BigDecimal tValue = new BigDecimal(123);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
		Date tTime = new Date();
		String testExceptOutput = sdf.format(tTime) + " Leo - ¥123" ;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(tName);
			copy.setTransactionValue(tValue);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
}
