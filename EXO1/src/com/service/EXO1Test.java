package com.service;

import com.exception.NoSquareException;
import com.model.Matrix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class EXO1Test {

    Matrix matrix1;
    Matrix matrix2;
    Matrix matrix3;
    Matrix matrix4;
    Matrix matrix5;
/** Test Matrix not square*/
    @Before
    public void initM5(){
        double[][] data = new double[1][2];
        data[0][0]=1;
        data[0][1]=4;
        matrix5 = new Matrix(data);
    }
    @Test //(expected = NoSquareException.class)
    public void exception()  throws NoSquareException{

        MatrixMathematics m = new MatrixMathematics();
        try {
            m.determinant(matrix5);
        }catch (NoSquareException e){System.out.println(e.getMessage());}
    }
/** Test determinant for 1 size matrix */
    @Before
    public void initM1() {
        double[][] data = new double[1][1];
        data[0][0] = 5;
        matrix1 = new Matrix(data);
    }

    @Test
    public void determinant1() throws NoSquareException {
        Assert.assertEquals(5,new MatrixMathematics().determinant(matrix1),0.0);

    }
/** Test determinant for 2 size matrix*/
   @Before
    public void initM2() {
        double[][] data = new double[2][2];
        data[0][0] = 1;
        data[0][1] = 2;
        data[1][0] = 5;
        data[1][1] = 6;
        matrix2 = new Matrix(data);
    }

    @Test
    public void determinant2() throws NoSquareException {
        assertEquals(-4,new MatrixMathematics().determinant(matrix2),0.0);
    }
/**Test determinant for more than 2 size matrix */
    @Before
    public void initM3() {
        double[][] data = new double[3][3];
        data[0][0] = 1;
        data[0][1] = 0;
        data[0][2] = 1;
        data[1][0] = 3;
        data[1][1] = 1;
        data[1][2] = 0;
        data[2][0] = 2;
        data[2][1] = 1;
        data[2][2] = 1;

        matrix3 = new Matrix(data);

    }

    @Test
    public void determinant3() throws NoSquareException {
        //assertTrue(new MatrixMathematics().determinant(matrix3) == 2);
        assertEquals(2,new MatrixMathematics().determinant(matrix3),0.0);

    }
    /**Test subMatrix */
    @Before
    public void initM4(){
        double[][] data = new double[2][2];
        data[0][0] = 1;
        data[0][1] = 0;
        data[1][0] = 1;
        data[1][1] = 1; //1
        matrix4 = new Matrix(data);
    }
    public void assertEquals1(Matrix m1, Matrix m2){
      for (int i =0;i<m1.getNrows();i++){
          for(int j = 0;j<m1.getNcols();j++){
             assertEquals(m1.getValueAt(i,j),m2.getValueAt(i,j),0.0);

          }
      }

    }
    @Test
    public void SubMatrix(){
    assertEquals1(matrix4,new MatrixMathematics().createSubMatrix(matrix3,0,0));
    }


}
