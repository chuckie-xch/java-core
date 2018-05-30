package com.bestcode.spring.ioc.beans.io;

import java.io.InputStream;

/**
 * 资源
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.29
 */
public interface Resource {

    InputStream getInputStream() throws Exception;
}
