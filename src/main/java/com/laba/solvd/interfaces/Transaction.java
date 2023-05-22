package com.laba.solvd.interfaces;

public interface Transaction {
    public void deposit(float amount);
    public void withdraw(float amount);
    public float getBalance();
}
