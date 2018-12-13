<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Games available now</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Title</th>
                        <th>Studio</th>
                        <th>Date of publishing</th>
                        <th>Genre</th>
                        <th>Language</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Rating</th>
                        <th>Producer first name</th>
                        <th>Producer last name</th>
                    </tr>
                    <xsl:for-each select="movies/movieStore/movie">
                        <tr bgcolor="#e9c6bc">
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="studio"/></td>
                            <td><xsl:value-of select="dateOfPublishing"/></td>
                            <td><xsl:value-of select="genre"/></td>
                            <td><xsl:value-of select="language"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="quantity"/></td>
                            <td><xsl:value-of select="rating"/></td>
                            <td><xsl:value-of select="firstname"/></td>
                            <td><xsl:value-of select="lastname"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
