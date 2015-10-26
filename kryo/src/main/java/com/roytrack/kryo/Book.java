package com.roytrack.kryo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ruanchangming on 2015/10/26.
 */
public class Book implements Serializable {
    private String bookName;
    private String ISBN;
    private BigDecimal price;
    private Date publicationDate;
    public Book(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        return !(publicationDate != null ? !publicationDate.equals(book.publicationDate) : book.publicationDate != null);

    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        return result;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
