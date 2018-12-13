
package jaxbclasses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for gameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Assassin's Creed Odyssey"/>
 *               &lt;enumeration value="Call of Duty: Black Ops 4"/>
 *               &lt;enumeration value="Destiny 2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="studio">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="2"/>
 *               &lt;pattern value="( [A-Z] [a-z] )*"/>
 *               &lt;enumeration value="Ubisoft"/>
 *               &lt;enumeration value="Activision"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dateOfPublishing">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *               &lt;enumeration value="2018-10-05"/>
 *               &lt;enumeration value="2018-12-10"/>
 *               &lt;enumeration value="2017-09-06"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="genre">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Action, RPG"/>
 *               &lt;enumeration value="Royal Battle, Action, Shooter, Royal Battle"/>
 *               &lt;enumeration value="Action, Shooter, Science-fiction"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="language">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Anvil engine"/>
 *               &lt;enumeration value="Modified IW 3.0"/>
 *               &lt;enumeration value="Tiger Engine"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="price">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;maxExclusive value="999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="quantity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="5"/>
 *               &lt;minExclusive value="1"/>
 *               &lt;maxExclusive value="10000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rating">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="Awesome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Great" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Good" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Normal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Bad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Awful" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="producer">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gameType", propOrder = {
    "title",
    "studio",
    "dateOfPublishing",
    "genre",
    "platform",
    "language",
    "price",
    "quantity",
    "rating",
    "producer"
})
public class GameType {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String studio;
    @XmlElement(required = true)
    protected String dateOfPublishing;
    @XmlElement(required = true)
    protected String genre;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(required = true)
    protected BigDecimal price;
    protected int quantity;
    @XmlElement(required = true)
    protected GameType.Rating rating;
    @XmlElement(required = true)
    protected GameType.Producer producer;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the studio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the value of the studio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudio(String value) {
        this.studio = value;
    }

    /**
     * Gets the value of the dateOfPublishing property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getYear() {
        return dateOfPublishing;
    }

    /**
     * Sets the value of the dateOfPublishing property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setYear(String value) {
        this.dateOfPublishing = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link GameType.Rating }
     *     
     */
    public GameType.Rating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     *
     * @param value
     *     allowed object is
     *     {@link GameType.Rating }
     *     
     */
    public void setRating(GameType.Rating value) {
        this.rating = value;
    }

    /**
     * Gets the value of the producer property.
     * 
     * @return
     *     possible object is
     *     {@link GameType.Producer }
     *     
     */
    public GameType.Producer getProducer() {
        return producer;
    }

    /**
     * Sets the value of the producer property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameType.Producer }
     *     
     */
    public void setProducer(GameType.Producer value) {
        this.producer = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Producer {

        @XmlElement(required = true)
        protected String firstname;
        @XmlElement(required = true)
        protected String lastname;

        /**
         * Gets the value of the firstname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstname() {
            return firstname;
        }

        /**
         * Sets the value of the firstname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstname(String value) {
            this.firstname = value;
        }

        /**
         * Gets the value of the lastname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastname() {
            return lastname;
        }

        /**
         * Sets the value of the lastname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastname(String value) {
            this.lastname = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="Awesome" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Great" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Good" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Normal" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Bad" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Awful" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "awesome",
        "great",
        "good",
        "normal",
        "bad",
        "awful"
    })
    public static class Rating {

        @XmlElement(name = "Awesome")
        protected String awesome = "Awesome";
        @XmlElement(name = "Great")
        protected String great = "Great";
        @XmlElement(name = "Good")
        protected String good = "Good";
        @XmlElement(name = "Normal")
        protected String normal = "Normal";
        @XmlElement(name = "Bad")
        protected String bad = "Bad";
        @XmlElement(name = "Awful")
        protected String awful = "Awful";

        /**
         * Gets the value of the awesome property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAwesome() {
            return awesome;
        }

        /**
         * Sets the value of the awesome property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAwesome(String value) {
            this.awesome = value;
        }

        /**
         * Gets the value of the great property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGreat() {
            return great;
        }

        /**
         * Sets the value of the great property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGreat(String value) {
            this.great = value;
        }

        /**
         * Gets the value of the good property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGood() {
            return good;
        }

        /**
         * Sets the value of the good property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGood(String value) {
            this.good = value;
        }

        /**
         * Gets the value of the normal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNormal() {
            return normal;
        }

        /**
         * Sets the value of the normal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNormal(String value) {
            this.normal = value;
        }

        /**
         * Gets the value of the bad property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBad() {
            return bad;
        }

        /**
         * Sets the value of the bad property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBad(String value) {
            this.bad = value;
        }

        /**
         * Gets the value of the awful property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAwful() {
            return awful;
        }

        /**
         * Sets the value of the awful property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAwful(String value) {
            this.awful = value;
        }

    }

}
