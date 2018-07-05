package com.bestcode.pattern.summary.chain;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public abstract class PostHandler {

    protected PostHandler successor;

    public void setSuccessor(PostHandler successor) {
        this.successor = successor;
    }

    public abstract void handlerRequest(Post post);

    protected final void next(Post post) {
        if (successor != null) {
            successor.handlerRequest(post);
        }
    }
}
