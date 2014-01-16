package umm.softwaredesign.stacklab;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author elenam
 *
 */
public class StackTests {
    /**
     * creating a new stack
     */
    StackIF<Integer> stackStartsWithNoElements = new Stack<Integer>();
    // to be initialized later:
    StackIF<String> stackStartsWithElements = null;
    
    /**
     * create a stack with some elements
     */
    @Before
    public void setup() {
        ArrayList<String> initialElements = new ArrayList<String>();
        initialElements.add("apple");
        initialElements.add("banana");
        initialElements.add("kiwi");
        stackStartsWithElements = new Stack<String>(initialElements);
    }
    
    
    
    /**
     * Testing that initially the first stack is empty 
     */
    @Test
    public void testEmptyStackIsEmpty() {
        assertTrue(stackStartsWithNoElements.isEmpty());
    }
    
    /**
     * Testing that the non-empty stack is not empty
     */
    @Test 
    public void testNonEmptyStackNotEmpty() {
        assertFalse(stackStartsWithElements.isEmpty());
    }

    /**
     * Testing to check that the top element of the stack is the 
     * one that was pushed. 
     */
    @Test
    public void testPushTop() {
        stackStartsWithNoElements.push(2);
        int top = stackStartsWithNoElements.top();
        assertEquals(top,2);
    }
    
    /**
     * Testing push and pop for an empty stack
     */
    @Test
    public void testPushPopEmpty() {
        stackStartsWithNoElements.push(2);
        int element = stackStartsWithNoElements.pop();
        assertEquals(element,2);
        assertTrue(stackStartsWithNoElements.isEmpty());
    }
    
    /**
     * Testing the LIFO behavior of a stack
     */
    @Test
    public void testLIFO() {
        stackStartsWithNoElements.push(1);
        stackStartsWithNoElements.push(2);
        int element1 = stackStartsWithNoElements.pop();
        int element2 = stackStartsWithNoElements.pop();
        assertEquals(element1,2);
        assertEquals(element2,1);
    }
    
    /**
     * Test popping elements from a non-empty stack
     */
    @Test
    public void testNonEmptyConstructorPop() {
        assertEquals(stackStartsWithElements.pop(),"kiwi");
        assertFalse(stackStartsWithElements.isEmpty());
        assertEquals(stackStartsWithElements.pop(),"banana");
        assertFalse(stackStartsWithElements.isEmpty());
        assertEquals(stackStartsWithElements.pop(),"apple");
        assertTrue(stackStartsWithElements.isEmpty());
    }
    
    /**
     * Testing that ptop()ushing and popping leaves a 
     * stack top element unchanged
     */
    @Test
    public void testPushPopNonEmpty() {
        String top = stackStartsWithElements.top();
        stackStartsWithElements.push("tomato");
        String element = stackStartsWithElements.pop();
        assertEquals(element,"tomato");
        // the stack wasn't empty, so it shouldn't be empty 
        // at this point
        assertFalse(stackStartsWithElements.isEmpty());
        // its top should be the same
        assertEquals(top,stackStartsWithElements.top());
    } 
    
    /**
     * Testing size with the initial stack setup
     */
    @Test
    public void testInitialSize() {
        assertEquals(stackStartsWithNoElements.size(),0);
        assertEquals(stackStartsWithElements.size(),3);
    }
    
    /**
     * Test that adding an element to a stack adds 1 to its size
     */
    @Test
    public void testSizeAfterPush() {
        stackStartsWithNoElements.push(100);
        assertEquals(stackStartsWithNoElements.size(),1);
        stackStartsWithElements.push("tomato");
        assertEquals(stackStartsWithElements.size(),4);
    }
    
    /**
     * Testing size after pushing and popping 
     */
    @Test
    public void testSizeAfterPushAndPop() {
        stackStartsWithNoElements.push(100);
        stackStartsWithNoElements.push(5);
        assertEquals(stackStartsWithNoElements.size(),2);
        stackStartsWithNoElements.pop();
        assertEquals(stackStartsWithNoElements.size(),1);
        stackStartsWithNoElements.pop();
        assertEquals(stackStartsWithNoElements.size(),0);
    }
    
    /**
     * Testing a stack after pushing and popping
     */
    @Test
    public void testPushPopSequence() {
        stackStartsWithNoElements.push(100);
        stackStartsWithNoElements.pop();
        stackStartsWithNoElements.push(5);
        int element = stackStartsWithNoElements.top();
        assertEquals(element,5);
        assertFalse(stackStartsWithNoElements.isEmpty());
        assertEquals(stackStartsWithNoElements.size(),1);       
    }
    
    /**
     * Testing that a stack with no elements contains no elements
     */
    @Test
    public void testHasElementsEmpty() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        assertTrue(stackStartsWithNoElements.hasElements(elements));
        elements.add(1);
        assertFalse(stackStartsWithNoElements.hasElements(elements));
    }
    
    /**
     * Test that the initial stack has the right elements
     */
    @Test
    public void testHasElementsInitial() {
        ArrayList<String> elements = new ArrayList<String>();
        elements.add("apple");
        elements.add("banana");
        elements.add("kiwi");
        assertTrue(stackStartsWithElements.hasElements(elements));
        elements.add("tomato");
        assertFalse(stackStartsWithElements.hasElements(elements));
    }
    
    /**
     * Testing that hasElements checks all the elements
     */
    @Test
    public void testHasElementsFewer() {
        ArrayList<String> elements = new ArrayList<String>();
        elements.add("apple");
        elements.add("banana");
        assertFalse(stackStartsWithElements.hasElements(elements));
    }
    
    /**
     * Testing that hasElements checks the order
     */
    @Test
    public void testHasElementsOrder() {
        ArrayList<String> elements = new ArrayList<String>();
        elements.add("apple");
        elements.add("kiwi");
        elements.add("banana");
        assertFalse(stackStartsWithElements.hasElements(elements));
    }
    
    /**
     * Testing hasElements after push );and pop
     */
    @Test
    public void testHasElementsPushPop() {
        ArrayList<String> elements = new ArrayList<String>();
        
        
        elements.add("apple");
        elements.add("banana");
        System.out.print(stackStartsWithElements.toString());
        stackStartsWithElements.pop();
        System.out.print(stackStartsWithElements.toString());
        assertTrue(stackStartsWithElements.hasElements(elements));
        System.out.print(stackStartsWithElements.toString());
        stackStartsWithElements.push("tomato");
        elements.add("tomato");
        assertTrue(stackStartsWithElements.hasElements(elements));
    }
    
    /**
     * Testing a string representation of an empty stack
     */
    @Test
    public void testToStringEmpty() {
        assertEquals(stackStartsWithNoElements.toString(),"Stack[]");
        
    }
    
    /**
     * Testing a string representation of a non-empty stack
     */
    @Test
    public void testToStringWithElements() {
        assertEquals(stackStartsWithElements.toString(),"Stack[apple, banana, kiwi]");
    }

}
