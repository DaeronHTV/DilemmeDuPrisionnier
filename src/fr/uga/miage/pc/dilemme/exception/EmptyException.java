package fr.uga.miage.pc.dilemme.exception;

/**
 * The class <code>ClassNotSupportedException</code> and its subclasses are a form of
 * <code>Throwable</code> that indicates conditions that a reasonable
 * application might want to catch.
 *
 * <p>The class {@code Exception} and any subclasses that are not also
 * subclasses of {@link RuntimeException} are <em>checked
 * exceptions</em>.  Checked exceptions need to be declared in a
 * method or constructor's <code>throws</code> clause if they can be thrown
 * by the execution of the method or constructor and propagate outside
 * the method or constructor boundary.
 *
 * @author Aurélien Avanzino - Stéphanie Gourdon
 * @see java.lang.Error
 * @see java.lang.Throwable
 * @since 3.0
 */
public class EmptyException extends Exception{
    private static final long serialVersionUID = -6197231991943210000L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     * @since 3.0
     */
    public EmptyException(){ super(); }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     * @since 3.0
     */
    public EmptyException(String message){ super(message); }

     /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  3.0
     */
    public EmptyException(String message, Throwable mThrow){ super(message, mThrow); }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of {@code (cause==null ? null : cause.toString())} (which
     * typically contains the class and detail message of {@code cause}).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  3.0
     */
    public EmptyException(Throwable mThrow){ super(mThrow); }
    
    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 3.0
     */
    protected EmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
