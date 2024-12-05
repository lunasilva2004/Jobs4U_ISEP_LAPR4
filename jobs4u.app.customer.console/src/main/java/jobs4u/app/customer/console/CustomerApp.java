/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.app.customer.console;

import jobs4u.app.customer.console.presentation.FrontMenu;
import jobs4u.core.serverManagement.application.CommunicationController;
import jobs4u.core.serverManagement.domain.MessageCode;

import java.net.Socket;

/**
 * Base User App.
 */
@SuppressWarnings("squid:S106")
public final class CustomerApp {

    private CustomerApp() {
    }

    private static final CommunicationController theController = new CommunicationController();

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        System.out.println("=====================================");
        System.out.println("Customer User App - Jobs4U");
        System.out.println("(C) 2024");
        System.out.println("=====================================");

        try {
            Socket socket = new Socket("127.0.0.1", 2004);
            theController.initializeComunication(socket);

            int code = theController.testConnection();
            if (code == MessageCode.ACK.getCode()) {
                System.out.println("Connection Established!");

            } else if (code == MessageCode.ERR.getCode()) {
                System.out.println("Connection refused! (ERR)");
                System.exit(0);

            } else {
                System.out.println("Unknown response!");
                System.exit(0);
            }

            FrontMenu frontMenu = new FrontMenu();
            frontMenu.show();

            socket.close();
        } catch (Exception e) {
            System.out.println("Error in the connection!");
        }

        // exiting the application, closing all threads
        System.exit(0);
    }
}