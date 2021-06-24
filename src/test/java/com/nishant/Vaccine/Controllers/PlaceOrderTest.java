package com.nishant.Vaccine.Controllers;

import com.nishant.Vaccine.Services.Impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlaceOrderTest {

    @Mock
    OrderServiceImpl orderService;

    @InjectMocks
    OrderController orderController;

    @Test
    void placeOrderWithProperCountAndAddress() throws NullPointerException{

//        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Mockito.any());

        // 1st Invocation
        when(orderService.placeOrder(Mockito.any())).thenReturn("V1");
        String res = orderController.placeOrder(2,"Meerut");

//        argumentCaptor.capture();

        Assertions.assertEquals("V1",res,"If proper count and address given, order should be placed");

        // 2nd Invocation
//        when(orderService.placeOrder(null)).thenThrow(NullPointerException.class);

        Assertions.assertThrows(
                NullPointerException.class,
                () -> orderController.placeOrder(0, "Meerut")
        );

//        verify(orderService, times(2)).placeOrder(any());
    }

    @Test
    void placeOrderWithEitherCountZeroOrAddressNull() throws NullPointerException{

        Assertions.assertThrows(
                NullPointerException.class,
                () -> orderController.placeOrder(0,"Meerut"),
                "If count is 0 it should not allow order placing and throw NullPointerException"
        );

        Assertions.assertThrows(
                NullPointerException.class,
                () -> orderController.placeOrder(2, null),
                "If address is Null it should not allow order placing and throw NullPointerException"
        );
    }

    @Test
    void cancelOrder() {

    }


//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

//    @After
//    public void cleanUp(){
//        System.out.println("CleanUp activity will be added");
//    }
}