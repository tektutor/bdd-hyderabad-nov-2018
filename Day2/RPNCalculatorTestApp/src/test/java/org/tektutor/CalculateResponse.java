
package org.tektutor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calculateReturn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "calculateReturn"
})
@XmlRootElement(name = "calculateResponse")
public class CalculateResponse {

    protected double calculateReturn;

    /**
     * Gets the value of the calculateReturn property.
     * 
     */
    public double getCalculateReturn() {
        return calculateReturn;
    }

    /**
     * Sets the value of the calculateReturn property.
     * 
     */
    public void setCalculateReturn(double value) {
        this.calculateReturn = value;
    }

}
