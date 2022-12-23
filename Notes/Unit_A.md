# Appendix
This appendix contains a quick reference for the major keywords, operators, escape sequences, and format specifiers in the Java programming language used in the AP subset.


## A - Operators

**Arithmetic Operators:**
* `+`: plus
* `-`: minus
* `*`: times
* `/`: divide
* `%`: modulus (or MOD) — returns the remainder from long (integer) division


**Assignment Operators:**
* `x = y`: set *variable* on left side equal to *value* (or variable) on the right side
* `x += y`: shorthand for `x = x + y`; add `y` to the current value of `x`
* `x -= y`: shorthand for `x = x - y`
* `x *= y`: shorthand for `x = x * y`
* `x /= y`: shorthand for `x = x / y`
* `x %= y`: shorthand for `x = x % y`
* `x++`: shorthand for `x = x + 1` or `x += 1`
* `x--`: shorthand for `x = x - 1` or `x -= 1`


**Unary Operators:**
* `()`: parenthesis
* `[]`: array subscript (index operator)
* `.`: object member selection
* `+`: unary plus (represent a number as positive `+2`)
* `-`: unary minus (represent a number as negative `-2`)
* `(type)`: type cast


**Conditional Operators:**
* `==`: exactly equal to 
* `!=`: not exactly equal to
* `>`: greater than
* `<`: less than
* `>=`: greater than or equal to
* `<=`: less than or equal to
* `instanceOf`: class membership


**Logical Operators:**
* `&&`: AND
* `||`: OR
* `!`: NOT



## B - Keywords

**Reserved Keywords:**

<table>
    <tr>
        <td>abstract</td>
        <td>boolean</td>
        <td>catch</td>
        <td>char</td>
    </tr>
    <tr>
        <td>class</td>
        <td>double</td>
        <td>else</td>
        <td>extends</td>
    </tr>
    <tr>
        <td>final</td>
        <td>for</td>
        <td>if</td>
        <td>implements</td>
    </tr>
    <tr>
        <td>import</td>
        <td>instanceof</td>
        <td>int</td>
        <td>interface</td>
    </tr>
    <tr>
        <td>new</td>
        <td>package</td>
        <td>private</td>
        <td>protected</td>
    </tr>
    <tr>
        <td>public</td>
        <td>return</td>
        <td>static</td>
        <td>super</td>
    </tr>
    <tr>
        <td>this</td>
        <td>try</td>
        <td>void</td>
        <td>while</td>
    </tr>
</table>


**Literals:**
* `true`
* `false`
* `null`



## C - Escape Sequences and Format Specifiers

**Escape Characters:**
* `\n`: new line (line break)
* `\t`: tab space
* `\'`: single quote
* `\"`: double quote
* `\\`: backslash


**Format Specifiers:**
* `%d`: int
* `%f`: double (`%.#f` to round to # decimal places)
* `%c`: char
* `%s`: String
