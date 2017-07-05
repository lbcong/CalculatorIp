/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerRest;

import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.IPAddressStringException;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorIp {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeding() {

        return "hello";
    }

    @RequestMapping(value = "/Ip", method = RequestMethod.GET)
    public String Ip(
            @RequestParam(value = "Ip", required = true) String Ip) {
        IPAddressString addrString = new IPAddressString(Ip);

        try {
            IPAddress addr = addrString.toAddress();
            String HostMin = addr.getLower().toString(); //192.168.10.0
            String HostMax = addr.getUpper().toString();
            return HostMin + "|" + HostMax;
        } catch (Exception e) {
        }
        //request.getRequestDispatcher("testc2").forward(request, respon);
        return "loi";
    }

}
