/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

/**
 *
 * @author Aluno
 */
public class CursoException extends Exception {

    /**
     * Creates a new instance of <code>CursoException</code> without detail
     * message.
     */
    public CursoException() {
    }

    /**
     * Constructs an instance of <code>CursoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CursoException(String msg) {
        super(msg);
    }
}
