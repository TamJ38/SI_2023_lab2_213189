package mk.finki.ukim;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void EveryBranch() {
        RuntimeException ex;
       ex = assertThrows(RuntimeException.class, () ->SILab2.function(null,null));
       assertTrue(ex.getMessage().contains("Mandatory information missing!"));

       User user = new User(null,"guessWho","tamara12@gmail.com");
       User user1 = new User("tamara12@gmail.com","guessWho","tamara12@gmail.com");
       User user2 = new User("kiko432@gmail.com","Knmjfs33","kiko432@gmail.com");
       List<User> list = new ArrayList<User>();
       list.add(user1);
       list.add(user2);
       assertFalse(SILab2.function(user,list));

        user = new User("Tamara","ggg","tamara12gmailcom");
        assertFalse(SILab2.function(user,list));

        user = new User("Tamara","guessWho#%","tamara12@gmail.com");
        list.remove(user1);
        user1 = new User("marko13@gmail.com","guessWhoM","marko15@gmail.com");
        list.add(user1);
        assertTrue(SILab2.function(user,list));

        user = new User("Tamara","guess Who #%","tamara12@gmail.com");
        assertFalse(SILab2.function(user,list));
    }
    @Test
    void MultipleCondition(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () ->SILab2.function(null,null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User user = new User("username","hebfhej","mail@gmail.com");
        ex = assertThrows(RuntimeException.class, () ->SILab2.function(user,null));
        assertFalse(ex.getMessage().contains("Mandatory information missing!"));

    }
}