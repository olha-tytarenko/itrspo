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
                        <th>Outcome date</th>
                        <th>Genre</th>
                        <th>Platforms</th>
                        <th>Series</th>
                        <th>Engine</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Promocode</th>
                        <th>Rating</th>
                        <th>Producer first name</th>
                        <th>Producer last name</th>
                    </tr>
                    <xsl:for-each select="games/gameStore/game">
                        <tr bgcolor="#e9c6bc">
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="studio"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="genre"/></td>
                            <td><xsl:value-of select="platform"/></td>
                            <td><xsl:value-of select="series"/></td>
                            <td><xsl:value-of select="engine"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="quantity"/></td>
                            <td><xsl:value-of select="promocode"/></td>
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
