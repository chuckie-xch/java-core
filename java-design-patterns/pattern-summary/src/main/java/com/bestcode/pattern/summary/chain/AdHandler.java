package com.bestcode.pattern.summary.chain;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class AdHandler extends PostHandler {
    @Override
    public void handlerRequest(Post post) {
        String content = post.getContent();
        content = content.replace("广告", "**");

    }
}
