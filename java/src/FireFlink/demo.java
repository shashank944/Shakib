package FireFlink;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

abstract class Bank
{
	﻿
	
	private String bankName;
	Bank(String bankName)
	{
	this.bankName = bankName;
	}
	}
	public String getBankName()
	{
	return bankName;
	}
	public class office extends Bank {
	office()
	{
	super("Axis Bank");
	}
	public static void main(String[] args)
	{
	}
	Bank bank = new office(); System.out.println(bank.getBankName());
}