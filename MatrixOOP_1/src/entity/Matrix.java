/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author win
 */
public class Matrix {
    
    private int[][] data;
    
    public int[][] getData() {
        return data;
    }
    
    public void setData(int[][] data) {
        this.data = data;
    }
    
    public Matrix add(Matrix other) throws Exception {
        int rows = data.length;
        int cols = data[0].length;
        int rows2 = other.data.length;
        int col2 = other.data[0].length;
        if (rows != rows2 || cols != col2) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        result.setData(dataResult);
        return result;
    }
    
    
    public Matrix subtract(Matrix other) throws Exception {
        int rows = data.length;
        int cols = data[0].length;
        int rows2 = other.data.length;
        int col2 = other.data[0].length;
        if (rows != rows2 || cols != col2) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        result.setData(dataResult);
        return result;
    }
    
    
    
    public Matrix multiply(Matrix other) throws Exception {
        int rows = data.length;
        int cols = data[0].length;
        int rows2 = other.data.length;
        int col2 = other.data[0].length;
        if (cols != rows2) {
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][col2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < cols; k++) {
                    dataResult[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        result.setData(dataResult);
        return result;
    }
    
    
    public String toString() {
        String str = "";
        int rows = data.length;
        int cols = data[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += String.format("[%d]", data[i][j]);
            }
            str += "\n";
        }
        return str;
    }
    
    public void input(int numberOfMatrix){
        int row=Validator.getInt("Enter row Matrix"+numberOfMatrix+":", "just be>0","Please Enter Integer Number", 1, Integer.MAX_VALUE);
        int col=Validator.getInt("Enter Col Matrix"+numberOfMatrix+":", "just be>0","Please Enter Integer Number", 1, Integer.MAX_VALUE);
        int data[][]=new int[row][col];
       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               data[i][j]=Validator.getInt("Enter Matrix"+numberOfMatrix+String.format("[%d][%d]:", i+1,j+1), "Error Range!", "value of Matrix is digit", Integer.MIN_VALUE,Integer.MAX_VALUE);
           }
       }
       setData(data);
    }
}
