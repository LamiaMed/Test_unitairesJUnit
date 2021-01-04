package com;
import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import org.junit.*;
import static org.junit.Assert.*;

public class DetTest {
    Matrix matrix1;
    Matrix matrix2;
    Matrix matrix3;

    @Before
    public void init() {
        double[][] data = new double[1][1];
        data[0][0] = 5;
        matrix1 = new Matrix(data);
    }

    @Test
    public void determinant1() throws NoSquareException {
        assertTrue(new MatrixMathematics().determinant(matrix1)==5);

    }

    @Before
    public void init2() {
        double[][] data = new double[2][2];
        data[0][0] = 1;
        data[0][1] = 2;
        data[1][0] = 5;
        data[1][1] = 6;
        matrix2 = new Matrix(data);
    }

    @Test
    public void determinant2() throws NoSquareException {
        assertTrue(new MatrixMathematics().determinant(matrix2) == -4);
    }

    @Before
    public void init3() {
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
        assertTrue(new MatrixMathematics().determinant(matrix3) == 2);
    }

}
