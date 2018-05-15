package com.bestcode.security.authentication.dao;

import com.bestcode.security.core.userdetails.UserDetails;

import org.junit.Test;

public class AbstractUserDetailsAuthenticationProviderTest {

    @Test
    public void testAssertNotNull() {
        UserDetails user = null;
//        org.springframework.util.Assert.notNull(user, "user is null");
    }

}
