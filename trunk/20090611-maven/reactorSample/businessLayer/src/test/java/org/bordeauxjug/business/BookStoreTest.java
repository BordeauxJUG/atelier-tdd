/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bordeauxjug.business;

import junit.framework.TestCase;

/**
 *
 * @author lfo
 */
public class BookStoreTest extends TestCase {
    
    public BookStoreTest(String testName) {
        super(testName);
    }

    public void testStore() {
        new BookStore().store(new Book());
    }

}
