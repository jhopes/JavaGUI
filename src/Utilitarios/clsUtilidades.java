
package Utilitarios;


import java.awt.Component;
import java.util.*;
import java.text.*;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
//import utils.ModelClass;

public class clsUtilidades {
    
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  
  /** Valida si el parámetro es una fecha con el formato "dd/MM/yyyy".
  * @return true si cumple el formato, false en caso contrario.
  */
public static boolean isFecha(String fechax) {
  try {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
      formatoFecha.setLenient(false);
      formatoFecha.parse(fechax);
  } catch (ParseException e) {
      return false;
  }
  return true;
}
  public static double getDecimal(int numeroDecimales,double decimal)
{
    decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
    decimal = java.lang.Math.round(decimal);
    decimal = decimal/java.lang.Math.pow(10, numeroDecimales);

return decimal; 
}
  public static String getFormattedNumber(Double p_number) { 
   NumberFormat l_nf = NumberFormat.getInstance(); 
   String  l_rVal; // Valor de retorno de la función. 

   l_nf.setMaximumFractionDigits(2);  // 2 decimales como mucho y como poco 
   l_nf.setMinimumFractionDigits(2); 

   l_rVal = new String ( l_nf.format(p_number.doubleValue())); 

   return l_rVal; 
}
  public static double setFormatNumber( double number){
    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    simbolos.setDecimalSeparator('.');
    DecimalFormat formateador = new DecimalFormat("####.####",simbolos);
     formateador.format(number);
     return number;
  }
  static public String localizedFormat(String pattern, double value, 
                                      Locale loc ) {
      NumberFormat nf = NumberFormat.getNumberInstance(loc);
      DecimalFormat df = (DecimalFormat)nf;
      df.applyPattern(pattern);
      String output = df.format(value);
      return output;
      //System.out.println(pattern + "  " + output + "  " + loc.toString());
   }
 
     public static <T> T iif(boolean test, T ifTrue, T ifFalse) {
            return test ? ifTrue : ifFalse;
        }
    public static boolean validaNumero(String Valor) {
        try {
            Integer.parseInt(Valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   public static void setOcultarColumnasJTable(JTable tbl, int columna[])
    {
        for(int i=0;i<columna.length;i++)
       {
             tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
             tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
             tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
             tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);

        }

    }

   public static double getTotales(JPanel pnl){
       double total=0.0;
      Component[] componentes =pnl.getComponents(); 
         for(int i=0; i<componentes.length;i++) 
             { 
                if(componentes[i] instanceof JTextField) 
                {
                    if(((JTextField)componentes[i]).isEditable()!=false){
                           if (validar(((JTextField)componentes[i]))!=false){
                               total+= Double.parseDouble(((JTextField)componentes[i]).getText());
                               volver(((JTextField)componentes[i]));
                           }
                        }
                   } 
                } 
     return total;
   }
   public static void limpiartxt(JPanel pnl){
          Component[] componentes =pnl.getComponents(); 
         for(int i=0; i<componentes.length;i++) 
             { 
                if(componentes[i] instanceof JTextField) 
                {
                     ((JTextField)componentes[i]).setText("");
                 } 
             } 
   }
/*  public static void limpiarDatos( JTable tbl,ModelClass modelo){
          int rows= tbl.getRowCount();
            for (int j = 0;j <rows; j++)
            {
                modelo.removeRow(0);
            }
  }*/
  public static void limpiarDatos( JTable tbl,DefaultTableModel modelo){
          int rows= tbl.getRowCount();
            for (int j = 0;j <rows; j++)
            {
                modelo.removeRow(0);
            }
  }
   /*public static double setInicializar(JPanel pnl){
       double total=0.0;
      Component[] componentes =pnl.getComponents(); 
         for(int i=0; i<componentes.length;i++) 
             { 
                if(componentes[i] instanceof JTextField) 
                {
                    if(((JTextField)componentes[i]).isEditable()!=false)
                    {
                        ((JTextField)componentes[i]).setDocument(new Lib.Utils.DocumenText.Doble(16,6));
                     }
                   } 
                } 
     return total;
   }*/
   
   public static boolean Validaciones(JPanel pnl){
   boolean res=false;
      Component[] componentes =pnl.getComponents(); 
      uno:for(int i=0; i<componentes.length;i++) 
             { 
                if(componentes[i] instanceof JTextField) 
                {
                   // if(((JTextField)componentes[i]).isEditable()!=false){
                           if (!validar(((JTextField)componentes[i]))){
                                res=false;
                           }
                           else{
                             res=true;
                             volver(((JTextField)componentes[i]));
                           }
                      //}
                   } 
                } 
   
   return res;
   }
   
   private static void volver(javax.swing.JTextField txt){
       txt.setBackground(new java.awt.Color(255,255,255));
    }
    private static boolean validar(javax.swing.JTextField txt){
        boolean r=true;
        if(txt.getText().equals("")){
           // if(!clsUtilidades.isNotEmpty(txt.getText()) && !clsUtilidades.isNumeric(txt.getText())){
                txt.setBackground(new java.awt.Color(250,194,211));
              //  txt.requestFocus();
                System.out.println(txt.getText());
                r = false;
           // }
        }
        else{
            if(clsUtilidades.isNotEmpty(txt.getText()) && clsUtilidades.isNumeric(txt.getText())){
                 r=true;
            }
        }
        return r;
    }
    

     public static boolean isNumber(String str) {
           if (clsUtilidades.isEmpty(str)) {
             return false;
         }
         char[] chars = str.toCharArray();
         int sz = chars.length;
         boolean hasExp = false;
         boolean hasDecPoint = false;
         boolean allowSigns = false;
         boolean foundDigit = false;
         // deal with any possible sign up front
         int start = (chars[0] == '-') ? 1 : 0;
 	          if (sz > start + 1) {
 	              if (chars[start] == '0' && chars[start + 1] == 'x') {
                 int i = start + 2;
 	                  if (i == sz) {
                     return false; // str == "0x"
                 }
                 // checking hex (it can't be anything else)
 	                  for (; i < chars.length; i++) {
                     if ((chars[i] < '0' || chars[i] > '9')
                         && (chars[i] < 'a' || chars[i] > 'f')
 	                          && (chars[i] < 'A' || chars[i] > 'F')) {
                         return false;
                     }
                 }
                 return true;
             }
         }
         sz--; // don't want to loop to the last char, check it afterwords
               // for type qualifiers
         int i = start;
         // loop to the next to last char or to the last char if we need another digit to
         // make a valid number (e.g. chars[0..5] = "1234E")
 	          while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
 	              if (chars[i] >= '0' && chars[i] <= '9') {
                 foundDigit = true;
                 allowSigns = false;
 
             } else if (chars[i] == '.') {
 	                  if (hasDecPoint || hasExp) {
                     // two decimal points or dec in exponent   
                     return false;
                 }
                 hasDecPoint = true;
             } else if (chars[i] == 'e' || chars[i] == 'E') {
                 // we've already taken care of hex.
 	                  if (hasExp) {
                     // two E's
                     return false;
                 }
 	                  if (!foundDigit) {
                     return false;
                 }
                 hasExp = true;
                 allowSigns = true;
             } else if (chars[i] == '+' || chars[i] == '-') {
 	                  if (!allowSigns) {
                     return false;
                 }
                 allowSigns = false;
                 foundDigit = false; // we need a digit after the E
             } else {
                 return false;
            }
             i++;
         }
 	          if (i < chars.length) {
 	              if (chars[i] >= '0' && chars[i] <= '9') {
                 // no type qualifier, OK
                 return true;
             }
 	              if (chars[i] == 'e' || chars[i] == 'E') {
                 // can't have an E at the last byte
                 return false;
             }
             if (!allowSigns
                 && (chars[i] == 'd'
                     || chars[i] == 'D'
                    || chars[i] == 'f'
 	                      || chars[i] == 'F')) {
                 return foundDigit;
             }
             if (chars[i] == 'l'
 	                  || chars[i] == 'L') {
                 // not allowing L with an exponent
                 return foundDigit && !hasExp;
             }
             // last character is illegal
             return false;
         }
         // allowSigns is true iff the val ends in 'E'
         // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
         return !allowSigns && foundDigit;
     }
    
    
   
    
    
    
    
    /*public static boolean isNumeric(String cad){
    for(char c:cad){
    
    }
    
    }*/
    
     // Performance testing notes (JDK 1.4, Jul03, scolebourne)
     // Whitespace:
     // Character.isWhitespace() is faster than WHITESPACE.indexOf()
     // where WHITESPACE is a string of all whitespace characters
     //
     // Character access:
     // String.charAt(n) versus toCharArray(), then array[n]
     // String.charAt(n) is about 15% worse for a 10K string
     // They are about equal for a length 50 string
     // String.charAt(n) is about 4 times better for a length 3 string
    // String.charAt(n) is best bet overall
     //
     // Append:
     // String.concat about twice as fast as StringBuffer.append
     // (not sure who tested this)
 
     /**
 141:     * The empty String <code>""</code>.
 142:     * @since 2.0
 143:     */
    public static final String EMPTY = "";

   /**
 147:     * Represents a failed index search.
 148:     * @since 2.1
 149:     */
     public static final int INDEX_NOT_FOUND = -1;
 
     /**
 153:     * <p>The maximum size to which the padding constant(s) can expand.</p>
 154:     */
     private static final int PAD_LIMIT = 8192;
 
     /**
 158:     * <p><code>StringUtils</code> instances should NOT be constructed in
 159:     * standard programming. Instead, the class should be used as
 160:     * <code>StringUtils.trim(" foo ");</code>.</p>
 161:     *
 162:     * <p>This constructor is public to permit tools that require a JavaBean
 163:     * instance to operate.</p>
 164:     */
 public clsUtilidades() {
         super();
     }
 
     // Empty checks
     //-----------------------------------------------------------------------
     /**
 172:     * <p>Checks if a String is empty ("") or null.</p>
 173:     *
 174:     * <pre>
 175:     * StringUtils.isEmpty(null)      = true
 176:     * StringUtils.isEmpty("")        = true
 177:     * StringUtils.isEmpty(" ")       = false
 178:     * StringUtils.isEmpty("bob")     = false
 179:     * StringUtils.isEmpty("  bob  ") = false
 180:     * </pre>
 181:     *
 182:     * <p>NOTE: This method changed in Lang version 2.0.
 183:     * It no longer trims the String.
 184:     * That functionality is available in isBlank().</p>
 185:     *
 186:     * @param str  the String to check, may be null
 187:     * @return <code>true</code> if the String is empty or null
 188:     */
public static boolean isEmpty(String str) {
         return str == null || str.length() == 0;
     }
 
     /**
 194:     * <p>Checks if a String is not empty ("") and not null.</p>
 195:     *
 196:     * <pre>
 197:     * StringUtils.isNotEmpty(null)      = false
 198:     * StringUtils.isNotEmpty("")        = false
 199:     * StringUtils.isNotEmpty(" ")       = true
 200:     * StringUtils.isNotEmpty("bob")     = true
 201:     * StringUtils.isNotEmpty("  bob  ") = true
 202:     * </pre>
 203:     *
 204:     * @param str  the String to check, may be null
 205:     * @return <code>true</code> if the String is not empty and not null
 206:     */
   public static boolean isNotEmpty(String str) {
         return !clsUtilidades.isEmpty(str);
     }
 
     /**
 212:     * <p>Checks if a String is whitespace, empty ("") or null.</p>
 213:     *
 214:     * <pre>
 215:     * StringUtils.isBlank(null)      = true
 216:     * StringUtils.isBlank("")        = true
 217:     * StringUtils.isBlank(" ")       = true
 218:     * StringUtils.isBlank("bob")     = false
 219:     * StringUtils.isBlank("  bob  ") = false
 220:     * </pre>
 221:     *
 222:     * @param str  the String to check, may be null
 223:     * @return <code>true</code> if the String is null, empty or whitespace
 224:     * @since 2.0
 225:     */
 public static boolean isBlank(String str) {
         int strLen;
 	          if (str == null || (strLen = str.length()) == 0) {
             return true;
         }
 	          for (int i = 0; i < strLen; i++) {
 	              if ((Character.isWhitespace(str.charAt(i)) == false)) {
                 return false;
             }
         }
         return true;
     }
 
     /**
 240:     * <p>Checks if a String is not empty (""), not null and not whitespace only.</p>
 241:     *
 242:     * <pre>
 243:     * StringUtils.isNotBlank(null)      = false
 244:     * StringUtils.isNotBlank("")        = false
 245:     * StringUtils.isNotBlank(" ")       = false
 246:     * StringUtils.isNotBlank("bob")     = true
 247:     * StringUtils.isNotBlank("  bob  ") = true
 248:     * </pre>
 249:     *
 250:     * @param str  the String to check, may be null
 251:     * @return <code>true</code> if the String is
 252:     *  not empty and not null and not whitespace
 253:     * @since 2.0
 254:     */
 

  public static boolean isNotBlank(String str) {
         return !clsUtilidades.isBlank(str);
     }
   public static boolean isNotBlank(JTextField txt) {
         if(clsUtilidades.isBlank(txt.getText()))
         {
                txt.setBackground(new java.awt.Color(250,194,211));
                System.out.println(txt.getText());
        }
         else{
               txt.setBackground(new java.awt.Color(255,255,255));
         }
         return !clsUtilidades.isBlank(txt.getText());
     }
     // Trim
     //-----------------------------------------------------------------------
     /**
 262:     * <p>Removes control characters (char &lt;= 32) from both
 263:     * ends of this String, handling <code>null</code> by returning
 264:     * an empty String ("").</p>
 265:     *
 266:     * <pre>
 267:     * StringUtils.clean(null)          = ""
 268:     * StringUtils.clean("")            = ""
 269:     * StringUtils.clean("abc")         = "abc"
 270:     * StringUtils.clean("    abc    ") = "abc"
 271:     * StringUtils.clean("     ")       = ""
 272:     * </pre>
 273:     *
 274:     * @see java.lang.String#trim()
 275:     * @param str  the String to clean, may be null
 276:     * @return the trimmed text, never <code>null</code>
 277:     * @deprecated Use the clearer named {@link #trimToEmpty(String)}.
 278:     *             Method will be removed in Commons Lang 3.0.
 279:     */
   public static String clean(String str) {
         return str == null ? EMPTY : str.trim();
     }
 
     /**
 285:     * <p>Removes control characters (char &lt;= 32) from both
 286:     * ends of this String, handling <code>null</code> by returning
 287:     * <code>null</code>.</p>
 288:     *
 289:     * <p>The String is trimmed using {@link String#trim()}.
 290:     * Trim removes start and end characters &lt;= 32.
 291:     * To strip whitespace use {@link #strip(String)}.</p>
 292:     *
 293:     * <p>To trim your choice of characters, use the
 294:     * {@link #strip(String, String)} methods.</p>
 295:     *
 296:     * <pre>
 297:     * StringUtils.trim(null)          = null
 298:     * StringUtils.trim("")            = ""
 299:     * StringUtils.trim("     ")       = ""
 300:     * StringUtils.trim("abc")         = "abc"
 301:     * StringUtils.trim("    abc    ") = "abc"
 302:     * </pre>
 303:     *
 304:     * @param str  the String to be trimmed, may be null
 305:     * @return the trimmed string, <code>null</code> if null String input
 306:     */
      public static String trim(String str) {
         return str == null ? null : str.trim();
     }
 
    /**
 312:     * <p>Removes control characters (char &lt;= 32) from both
 313:     * ends of this String returning <code>null</code> if the String is
 314:     * empty ("") after the trim or if it is <code>null</code>.
 315:     *
 316:     * <p>The String is trimmed using {@link String#trim()}.
 317:     * Trim removes start and end characters &lt;= 32.
 318:     * To strip whitespace use {@link #stripToNull(String)}.</p>
 319:     *
 320:     * <pre>
 321:     * StringUtils.trimToNull(null)          = null
 322:     * StringUtils.trimToNull("")            = null
 323:     * StringUtils.trimToNull("     ")       = null
 324:     * StringUtils.trimToNull("abc")         = "abc"
 325:     * StringUtils.trimToNull("    abc    ") = "abc"
 326:     * </pre>
 327:     *
 328:     * @param str  the String to be trimmed, may be null
 329:     * @return the trimmed String,
 330:     *  <code>null</code> if only chars &lt;= 32, empty or null String input
 331:     * @since 2.0
 332:     */
       public static String trimToNull(String str) {
        String ts = trim(str);
         return isEmpty(ts) ? null : ts;
    }

     /**
 339:     * <p>Removes control characters (char &lt;= 32) from both
 340:     * ends of this String returning an empty String ("") if the String
 341:     * is empty ("") after the trim or if it is <code>null</code>.
 342:     *
 343:     * <p>The String is trimmed using {@link String#trim()}.
 344:     * Trim removes start and end characters &lt;= 32.
 345:     * To strip whitespace use {@link #stripToEmpty(String)}.</p>
 346:     *
 347:     * <pre>
 348:     * StringUtils.trimToEmpty(null)          = ""
 349:     * StringUtils.trimToEmpty("")            = ""
 350:     * StringUtils.trimToEmpty("     ")       = ""
 351:     * StringUtils.trimToEmpty("abc")         = "abc"
 352:     * StringUtils.trimToEmpty("    abc    ") = "abc"
 353:     * </pre>
 354:     *
 355:     * @param str  the String to be trimmed, may be null
 356:     * @return the trimmed String, or an empty String if <code>null</code> input
 357:     * @since 2.0
 358:     */
      public static String trimToEmpty(String str) {
         return str == null ? EMPTY : str.trim();
     }
 
     // Stripping
     //-----------------------------------------------------------------------
     /**
 366:     * <p>Strips whitespace from the start and end of a String.</p>
 367:     *
 368:     * <p>This is similar to {@link #trim(String)} but removes whitespace.
 369:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
 370:     *
 371:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
 372:     *
 373:     * <pre>
 374:     * StringUtils.strip(null)     = null
 375:     * StringUtils.strip("")       = ""
 376:     * StringUtils.strip("   ")    = ""
 377:     * StringUtils.strip("abc")    = "abc"
 378:     * StringUtils.strip("  abc")  = "abc"
 379:     * StringUtils.strip("abc  ")  = "abc"
 380:     * StringUtils.strip(" abc ")  = "abc"
 381:     * StringUtils.strip(" ab c ") = "ab c"
 382:     * </pre>
 383:     *
 384:     * @param str  the String to remove whitespace from, may be null
 385:     * @return the stripped String, <code>null</code> if null String input
 386:     */
     public static String strip(String str) {
         return strip(str, null);
     }
 
     /**
 392:     * <p>Strips whitespace from the start and end of a String  returning
 393:     * <code>null</code> if the String is empty ("") after the strip.</p>
 394:     *
 395:     * <p>This is similar to {@link #trimToNull(String)} but removes whitespace.
 396:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
 397:     *
 398:     * <pre>
 399:     * StringUtils.stripToNull(null)     = null
 400:     * StringUtils.stripToNull("")       = null
 401:     * StringUtils.stripToNull("   ")    = null
 402:     * StringUtils.stripToNull("abc")    = "abc"
 403:     * StringUtils.stripToNull("  abc")  = "abc"
 404:     * StringUtils.stripToNull("abc  ")  = "abc"
 405:     * StringUtils.stripToNull(" abc ")  = "abc"
 406:     * StringUtils.stripToNull(" ab c ") = "ab c"
 407:     * </pre>
 408:     *
 409:     * @param str  the String to be stripped, may be null
 410:     * @return the stripped String,
 411:     *  <code>null</code> if whitespace, empty or null String input
 412:     * @since 2.0
 413:     */
 	      public static String stripToNull(String str) {
 	          if (str == null) {
             return null;
         }
         str = strip(str, null);
         return str.length() == 0 ? null : str;
     }
 
     /**
 423:     * <p>Strips whitespace from the start and end of a String  returning
 424:     * an empty String if <code>null</code> input.</p>
 425:     *
 426:     * <p>This is similar to {@link #trimToEmpty(String)} but removes whitespace.
 427:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
 428:     *
 429:     * <pre>
 430:     * StringUtils.stripToEmpty(null)     = ""
 431:     * StringUtils.stripToEmpty("")       = ""
 432:     * StringUtils.stripToEmpty("   ")    = ""
 433:     * StringUtils.stripToEmpty("abc")    = "abc"
 434:     * StringUtils.stripToEmpty("  abc")  = "abc"
 435:     * StringUtils.stripToEmpty("abc  ")  = "abc"
 436:     * StringUtils.stripToEmpty(" abc ")  = "abc"
 437:     * StringUtils.stripToEmpty(" ab c ") = "ab c"
 438:     * </pre>
 439:     *
 440:     * @param str  the String to be stripped, may be null
 441:     * @return the trimmed String, or an empty String if <code>null</code> input
 442:     * @since 2.0
 443:     */
    public static String stripToEmpty(String str) {
         return str == null ? EMPTY : strip(str, null);
     }
 
     /**
 449:     * <p>Strips any of a set of characters from the start and end of a String.
 450:     * This is similar to {@link String#trim()} but allows the characters
 451:     * to be stripped to be controlled.</p>
 452:     *
 453:     * <p>A <code>null</code> input String returns <code>null</code>.
 454:     * An empty string ("") input returns the empty string.</p>
 455:     *
 456:     * <p>If the stripChars String is <code>null</code>, whitespace is
 457:     * stripped as defined by {@link Character#isWhitespace(char)}.
 458:     * Alternatively use {@link #strip(String)}.</p>
 459:     *
 460:     * <pre>
 461:     * StringUtils.strip(null, *)          = null
 462:     * StringUtils.strip("", *)            = ""
 463:     * StringUtils.strip("abc", null)      = "abc"
 464:     * StringUtils.strip("  abc", null)    = "abc"
 465:     * StringUtils.strip("abc  ", null)    = "abc"
 466:     * StringUtils.strip(" abc ", null)    = "abc"
 467:     * StringUtils.strip("  abcyx", "xyz") = "  abc"
 468:     * </pre>
 469:     *
 470:     * @param str  the String to remove characters from, may be null
 471:     * @param stripChars  the characters to remove, null treated as whitespace
 472:     * @return the stripped String, <code>null</code> if null String input
 473:     */
    public static String strip(String str, String stripChars) {
 	          if (isEmpty(str)) {
             return str;
         }
         str = stripStart(str, stripChars);
         return stripEnd(str, stripChars);
     }
 
     /**
 483:     * <p>Strips any of a set of characters from the start of a String.</p>
 484:     *
 485:     * <p>A <code>null</code> input String returns <code>null</code>.
 486:     * An empty string ("") input returns the empty string.</p>
 487:     *
 488:     * <p>If the stripChars String is <code>null</code>, whitespace is
 489:     * stripped as defined by {@link Character#isWhitespace(char)}.</p>
 490:     *
 491:     * <pre>
 492:     * StringUtils.stripStart(null, *)          = null
 493:     * StringUtils.stripStart("", *)            = ""
 494:     * StringUtils.stripStart("abc", "")        = "abc"
 495:     * StringUtils.stripStart("abc", null)      = "abc"
 496:     * StringUtils.stripStart("  abc", null)    = "abc"
 497:     * StringUtils.stripStart("abc  ", null)    = "abc  "
 498:     * StringUtils.stripStart(" abc ", null)    = "abc "
 499:     * StringUtils.stripStart("yxabc  ", "xyz") = "abc  "
 500:     * </pre>
 501:     *
 502:     * @param str  the String to remove characters from, may be null
 503:     * @param stripChars  the characters to remove, null treated as whitespace
 504:     * @return the stripped String, <code>null</code> if null String input
 505:     */
  public static String stripStart(String str, String stripChars) {
         int strLen;
 	          if (str == null || (strLen = str.length()) == 0) {
             return str;
         }
         int start = 0;
 	          if (stripChars == null) {
 	              while ((start != strLen) && Character.isWhitespace(str.charAt(start))) {
                 start++;
             }
         } else if (stripChars.length() == 0) {
             return str;
         } else {
 	              while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1)) {
                 start++;
             }
         }
         return str.substring(start);
     }
 
     /**
 527:     * <p>Strips any of a set of characters from the end of a String.</p>
 528:     *
 529:     * <p>A <code>null</code> input String returns <code>null</code>.
 530:     * An empty string ("") input returns the empty string.</p>
 531:     *
 532:     * <p>If the stripChars String is <code>null</code>, whitespace is
 533:     * stripped as defined by {@link Character#isWhitespace(char)}.</p>
 534:     *
 535:     * <pre>
 536:     * StringUtils.stripEnd(null, *)          = null
 537:     * StringUtils.stripEnd("", *)            = ""
 538:     * StringUtils.stripEnd("abc", "")        = "abc"
 539:     * StringUtils.stripEnd("abc", null)      = "abc"
 540:     * StringUtils.stripEnd("  abc", null)    = "  abc"
 541:     * StringUtils.stripEnd("abc  ", null)    = "abc"
 542:     * StringUtils.stripEnd(" abc ", null)    = " abc"
 543:     * StringUtils.stripEnd("  abcyx", "xyz") = "  abc"
 544:     * </pre>
 545:     *
 546:     * @param str  the String to remove characters from, may be null
 547:     * @param stripChars  the characters to remove, null treated as whitespace
 548:     * @return the stripped String, <code>null</code> if null String input
 549:     */
    public static String stripEnd(String str, String stripChars) {
         int end;
 	          if (str == null || (end = str.length()) == 0) {
             return str;
         }
 
 	          if (stripChars == null) {
 	              while ((end != 0) && Character.isWhitespace(str.charAt(end - 1))) {
                 end--;
             }
        } else if (stripChars.length() == 0) {
             return str;
         } else {
 	              while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                 end--;
             }
         }
         return str.substring(0, end);
     }
 
     // StripAll
     //-----------------------------------------------------------------------
     /**
 573:     * <p>Strips whitespace from the start and end of every String in an array.
 574:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
 575:     *
 576:     * <p>A new array is returned each time, except for length zero.
 577:     * A <code>null</code> array will return <code>null</code>.
 578:     * An empty array will return itself.
 579:     * A <code>null</code> array entry will be ignored.</p>
 580:     *
 581:     * <pre>
 582:     * StringUtils.stripAll(null)             = null
 583:     * StringUtils.stripAll([])               = []
 584:     * StringUtils.stripAll(["abc", "  abc"]) = ["abc", "abc"]
 585:     * StringUtils.stripAll(["abc  ", null])  = ["abc", null]
 586:     * </pre>
 587:     *
 588:     * @param strs  the array to remove whitespace from, may be null
 589:     * @return the stripped Strings, <code>null</code> if null array input
 590:     */
   public static String[] stripAll(String[] strs) {
         return stripAll(strs, null);
     }
 
     /**
 596:     * <p>Strips any of a set of characters from the start and end of every
 597:     * String in an array.</p>
 598:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
 599:     *
 600:     * <p>A new array is returned each time, except for length zero.
 601:     * A <code>null</code> array will return <code>null</code>.
 602:     * An empty array will return itself.
 603:     * A <code>null</code> array entry will be ignored.
 604:     * A <code>null</code> stripChars will strip whitespace as defined by
 605:     * {@link Character#isWhitespace(char)}.</p>
 606:     *
 607:     * <pre>
 608:     * StringUtils.stripAll(null, *)                = null
 609:     * StringUtils.stripAll([], *)                  = []
 610:     * StringUtils.stripAll(["abc", "  abc"], null) = ["abc", "abc"]
 611:     * StringUtils.stripAll(["abc  ", null], null)  = ["abc", null]
 612:     * StringUtils.stripAll(["abc  ", null], "yz")  = ["abc  ", null]
 613:     * StringUtils.stripAll(["yabcz", null], "yz")  = ["abc", null]
 614:     * </pre>
 615:     *
 616:     * @param strs  the array to remove characters from, may be null
 617:     * @param stripChars  the characters to remove, null treated as whitespace
 618:     * @return the stripped Strings, <code>null</code> if null array input
 619:     */
      public static String[] stripAll(String[] strs, String stripChars) {
         int strsLen;
 	          if (strs == null || (strsLen = strs.length) == 0) {
             return strs;
         }
         String[] newArr = new String[strsLen];
 	          for (int i = 0; i < strsLen; i++) {
             newArr[i] = strip(strs[i], stripChars);
         }
         return newArr;
    }
 
     // Equals
     //-----------------------------------------------------------------------
     /**
 635:     * <p>Compares two Strings, returning <code>true</code> if they are equal.</p>
 636:     *
 637:     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
 638:     * references are considered to be equal. The comparison is case sensitive.</p>
 639:     *
 640:     * <pre>
 641:     * StringUtils.equals(null, null)   = true
 642:     * StringUtils.equals(null, "abc")  = false
 643:     * StringUtils.equals("abc", null)  = false
 644:     * StringUtils.equals("abc", "abc") = true
 645:     * StringUtils.equals("abc", "ABC") = false
 646:     * </pre>
 647:     *
 648:     * @see java.lang.String#equals(Object)
 649:     * @param str1  the first String, may be null
 650:     * @param str2  the second String, may be null
 651:     * @return <code>true</code> if the Strings are equal, case sensitive, or
 652:     *  both <code>null</code>
 653:     */
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
     }
 
     /**
 659:     * <p>Compares two Strings, returning <code>true</code> if they are equal ignoring
 660:     * the case.</p>
 661:     *
 662:     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
 663:     * references are considered equal. Comparison is case insensitive.</p>
 664:     *
 665:     * <pre>
 666:     * StringUtils.equalsIgnoreCase(null, null)   = true
 667:     * StringUtils.equalsIgnoreCase(null, "abc")  = false
 668:     * StringUtils.equalsIgnoreCase("abc", null)  = false
 669:     * StringUtils.equalsIgnoreCase("abc", "abc") = true
 670:     * StringUtils.equalsIgnoreCase("abc", "ABC") = true
 671:     * </pre>
 672:     *
 673:     * @see java.lang.String#equalsIgnoreCase(String)
 674:     * @param str1  the first String, may be null
 675:     * @param str2  the second String, may be null
 676:     * @return <code>true</code> if the Strings are equal, case insensitive, or
 677:     *  both <code>null</code>
 678:     */
      public static boolean equalsIgnoreCase(String str1, String str2) {
         return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
     }
 
     // IndexOf
     //-----------------------------------------------------------------------
     /**
 686:     * <p>Finds the first index within a String, handling <code>null</code>.
 687:     * This method uses {@link String#indexOf(int)}.</p>
 688:     *
 689:     * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.</p>
 690:     *
 691:     * <pre>
 692:     * StringUtils.indexOf(null, *)         = -1
 693:     * StringUtils.indexOf("", *)           = -1
 694:     * StringUtils.indexOf("aabaabaa", 'a') = 0
 695:     * StringUtils.indexOf("aabaabaa", 'b') = 2
 696:     * </pre>
 697:     *
 698:     * @param str  the String to check, may be null
 699:     * @param searchChar  the character to find
 700:     * @return the first index of the search character,
 701:     *  -1 if no match or <code>null</code> string input
 702:     * @since 2.0
 703:     */
      public static int indexOf(String str, char searchChar) {
 	          if (isEmpty(str)) {
             return -1;
         }
         return str.indexOf(searchChar);
     }
 
    /**
 712:     * <p>Finds the first index within a String from a start position,
 713:     * handling <code>null</code>.
 714:     * This method uses {@link String#indexOf(int, int)}.</p>
 715:     *
 716:     * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.
 717:     * A negative start position is treated as zero.
 718:     * A start position greater than the string length returns <code>-1</code>.</p>
 719:     *
 720:     * <pre>
 721:     * StringUtils.indexOf(null, *, *)          = -1
 722:     * StringUtils.indexOf("", *, *)            = -1
 723:     * StringUtils.indexOf("aabaabaa", 'b', 0)  = 2
 724:     * StringUtils.indexOf("aabaabaa", 'b', 3)  = 5
 725:     * StringUtils.indexOf("aabaabaa", 'b', 9)  = -1
 726:     * StringUtils.indexOf("aabaabaa", 'b', -1) = 2
 727:     * </pre>
 728:     *
 729:     * @param str  the String to check, may be null
 730:     * @param searchChar  the character to find
 731:     * @param startPos  the start position, negative treated as zero
 732:     * @return the first index of the search character,
 733:     *  -1 if no match or <code>null</code> string input
 734:     * @since 2.0
 735:     */
      public static int indexOf(String str, char searchChar, int startPos) {
 	          if (isEmpty(str)) {
             return -1;
         }
         return str.indexOf(searchChar, startPos);
     }
 
     /**
 744:     * <p>Finds the first index within a String, handling <code>null</code>.
 745:     * This method uses {@link String#indexOf(String)}.</p>
 746:     *
 747:     * <p>A <code>null</code> String will return <code>-1</code>.</p>
 748:     *
 749:     * <pre>
 750:     * StringUtils.indexOf(null, *)          = -1
 751:     * StringUtils.indexOf(*, null)          = -1
 752:     * StringUtils.indexOf("", "")           = 0
 753:     * StringUtils.indexOf("aabaabaa", "a")  = 0
 754:     * StringUtils.indexOf("aabaabaa", "b")  = 2
 755:     * StringUtils.indexOf("aabaabaa", "ab") = 1
 756:     * StringUtils.indexOf("aabaabaa", "")   = 0
 757:     * </pre>
 758:     *
 759:     * @param str  the String to check, may be null
 760:     * @param searchStr  the String to find, may be null
 761:     * @return the first index of the search String,
 762:     *  -1 if no match or <code>null</code> string input
 763:     * @since 2.0
 764:     */
 	      public static int indexOf(String str, String searchStr) {
 	          if (str == null || searchStr == null) {
             return -1;
         }
         return str.indexOf(searchStr);
     }
 
     /**
 773:     * <p>Finds the n-th index within a String, handling <code>null</code>.
 774:     * This method uses {@link String#indexOf(String)}.</p>
 775:     *
 776:     * <p>A <code>null</code> String will return <code>-1</code>.</p>
 777:     *
 778:     * <pre>
 779:     * StringUtils.ordinalIndexOf(null, *, *)          = -1
 780:     * StringUtils.ordinalIndexOf(*, null, *)          = -1
 781:     * StringUtils.ordinalIndexOf("", "", *)           = 0
 782:     * StringUtils.ordinalIndexOf("aabaabaa", "a", 1)  = 0
 783:     * StringUtils.ordinalIndexOf("aabaabaa", "a", 2)  = 1
 784:     * StringUtils.ordinalIndexOf("aabaabaa", "b", 1)  = 2
 785:     * StringUtils.ordinalIndexOf("aabaabaa", "b", 2)  = 5
 786:     * StringUtils.ordinalIndexOf("aabaabaa", "ab", 1) = 1
 787:     * StringUtils.ordinalIndexOf("aabaabaa", "ab", 2) = 4
 788:     * StringUtils.ordinalIndexOf("aabaabaa", "", 1)   = 0
 789:     * StringUtils.ordinalIndexOf("aabaabaa", "", 2)   = 0
 790:     * </pre>
 791:     *
 792:     * @param str  the String to check, may be null
 793:     * @param searchStr  the String to find, may be null
 794:     * @param ordinal  the n-th <code>searchStr</code> to find
 795:     * @return the n-th index of the search String,
 796:     *  <code>-1</code> (<code>INDEX_NOT_FOUND</code>) if no match or <code>null</code> string input
 797:     * @since 2.1
 798:     */
     public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
 	          if (str == null || searchStr == null || ordinal <= 0) {
             return INDEX_NOT_FOUND;
         }
 	          if (searchStr.length() == 0) {
             return 0;
         }
         int found = 0;
         int index = INDEX_NOT_FOUND;
 	          do {
             index = str.indexOf(searchStr, index + 1);
 	              if (index < 0) {
                 return index;
             }
             found++;
         } while (found < ordinal);
         return index;
     }
      /**
 819:     * <p>Finds the first index within a String, handling <code>null</code>.
 820:     * This method uses {@link String#indexOf(String, int)}.</p>
 821:     *
 822:     * <p>A <code>null</code> String will return <code>-1</code>.
 823:     * A negative start position is treated as zero.
 824:     * An empty ("") search String always matches.
 825:     * A start position greater than the string length only matches
 826:     * an empty search String.</p>
 827:     *
 828:     * <pre>
 829:     * StringUtils.indexOf(null, *, *)          = -1
 830:     * StringUtils.indexOf(*, null, *)          = -1
 831:     * StringUtils.indexOf("", "", 0)           = 0
 832:     * StringUtils.indexOf("aabaabaa", "a", 0)  = 0
 833:     * StringUtils.indexOf("aabaabaa", "b", 0)  = 2
 834:     * StringUtils.indexOf("aabaabaa", "ab", 0) = 1
 835:     * StringUtils.indexOf("aabaabaa", "b", 3)  = 5
 836:     * StringUtils.indexOf("aabaabaa", "b", 9)  = -1
 837:     * StringUtils.indexOf("aabaabaa", "b", -1) = 2
 838:     * StringUtils.indexOf("aabaabaa", "", 2)   = 2
 839:     * StringUtils.indexOf("abc", "", 9)        = 3
 840:     * </pre>
 841:     *
 842:     * @param str  the String to check, may be null
 843:     * @param searchStr  the String to find, may be null
 844:     * @param startPos  the start position, negative treated as zero
 845:     * @return the first index of the search String,
 846:     *  -1 if no match or <code>null</code> string input
 847:     * @since 2.0
 848:     */
     public static int indexOf(String str, String searchStr, int startPos) {
 	          if (str == null || searchStr == null) {
             return -1;
         }
         // JDK1.2/JDK1.3 have a bug, when startPos > str.length for "", hence
           if (searchStr.length() == 0 && startPos >= str.length()) {
             return str.length();
         }
        return str.indexOf(searchStr, startPos);
     }
 
     // LastIndexOf
     //-----------------------------------------------------------------------
     /**
 863:     * <p>Finds the last index within a String, handling <code>null</code>.
 864:     * This method uses {@link String#lastIndexOf(int)}.</p>
 865:     *
 866:     * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.</p>
 867:     *
 868:     * <pre>
 869:     * StringUtils.lastIndexOf(null, *)         = -1
 870:     * StringUtils.lastIndexOf("", *)           = -1
 871:     * StringUtils.lastIndexOf("aabaabaa", 'a') = 7
 872:     * StringUtils.lastIndexOf("aabaabaa", 'b') = 5
 873:     * </pre>
 874:     *
 875:     * @param str  the String to check, may be null
 876:     * @param searchChar  the character to find
 877:     * @return the last index of the search character,
 878:     *  -1 if no match or <code>null</code> string input
 879:     * @since 2.0
 880:     */
      public static int lastIndexOf(String str, char searchChar) {
           if (isEmpty(str)) {
             return -1;
         }
        return str.lastIndexOf(searchChar);
     }
 
     /**
 889:     * <p>Finds the last index within a String from a start position,
 890:     * handling <code>null</code>.
 891:     * This method uses {@link String#lastIndexOf(int, int)}.</p>
 892:     *
 893:     * <p>A <code>null</code> or empty ("") String will return <code>-1</code>.
 894:     * A negative start position returns <code>-1</code>.
 895:     * A start position greater than the string length searches the whole string.</p>
 896:     *
 897:     * <pre>
 898:     * StringUtils.lastIndexOf(null, *, *)          = -1
 899:     * StringUtils.lastIndexOf("", *,  *)           = -1
 900:     * StringUtils.lastIndexOf("aabaabaa", 'b', 8)  = 5
 901:     * StringUtils.lastIndexOf("aabaabaa", 'b', 4)  = 2
 902:     * StringUtils.lastIndexOf("aabaabaa", 'b', 0)  = -1
 903:     * StringUtils.lastIndexOf("aabaabaa", 'b', 9)  = 5
 904:     * StringUtils.lastIndexOf("aabaabaa", 'b', -1) = -1
 905:     * StringUtils.lastIndexOf("aabaabaa", 'a', 0)  = 0
 906:     * </pre>
 907:     *
 908:     * @param str  the String to check, may be null
 909:     * @param searchChar  the character to find
 910:     * @param startPos  the start position
 911:     * @return the last index of the search character,
 912:     *  -1 if no match or <code>null</code> string input
 913:     * @since 2.0
 914:     */
      public static int lastIndexOf(String str, char searchChar, int startPos) {
 	          if (isEmpty(str)) {
             return -1;
         }
         return str.lastIndexOf(searchChar, startPos);
     }
 
     /**
 923:     * <p>Finds the last index within a String, handling <code>null</code>.
 924:     * This method uses {@link String#lastIndexOf(String)}.</p>
 925:     *
 926:     * <p>A <code>null</code> String will return <code>-1</code>.</p>
 927:     *
 928:     * <pre>
 929:     * StringUtils.lastIndexOf(null, *)          = -1
 930:     * StringUtils.lastIndexOf(*, null)          = -1
 931:     * StringUtils.lastIndexOf("", "")           = 0
 932:     * StringUtils.lastIndexOf("aabaabaa", "a")  = 0
 933:     * StringUtils.lastIndexOf("aabaabaa", "b")  = 2
 934:     * StringUtils.lastIndexOf("aabaabaa", "ab") = 1
 935:     * StringUtils.lastIndexOf("aabaabaa", "")   = 8
 936:     * </pre>
 937:     *
 938:     * @param str  the String to check, may be null
 939:     * @param searchStr  the String to find, may be null
 940:     * @return the last index of the search String,
 941:     *  -1 if no match or <code>null</code> string input
 942:     * @since 2.0
 943:     */
      public static int lastIndexOf(String str, String searchStr) {
 	          if (str == null || searchStr == null) {
             return -1;
         }
         return str.lastIndexOf(searchStr);
     }
 
     /**
 952:     * <p>Finds the first index within a String, handling <code>null</code>.
 953:     * This method uses {@link String#lastIndexOf(String, int)}.</p>
 954:     *
 955:     * <p>A <code>null</code> String will return <code>-1</code>.
 956:     * A negative start position returns <code>-1</code>.
 957:     * An empty ("") search String always matches unless the start position is negative.
 958:     * A start position greater than the string length searches the whole string.</p>
 959:     *
 960:     * <pre>
 961:     * StringUtils.lastIndexOf(null, *, *)          = -1
 962:     * StringUtils.lastIndexOf(*, null, *)          = -1
 963:     * StringUtils.lastIndexOf("aabaabaa", "a", 8)  = 7
 964:     * StringUtils.lastIndexOf("aabaabaa", "b", 8)  = 5
 965:     * StringUtils.lastIndexOf("aabaabaa", "ab", 8) = 4
 966:     * StringUtils.lastIndexOf("aabaabaa", "b", 9)  = 5
 967:     * StringUtils.lastIndexOf("aabaabaa", "b", -1) = -1
 968:     * StringUtils.lastIndexOf("aabaabaa", "a", 0)  = 0
 969:     * StringUtils.lastIndexOf("aabaabaa", "b", 0)  = -1
 970:     * </pre>
 971:     *
 972:     * @param str  the String to check, may be null
 973:     * @param searchStr  the String to find, may be null
 974:     * @param startPos  the start position, negative treated as zero
 975:     * @return the first index of the search String,
 976:     *  -1 if no match or <code>null</code> string input
 977:     * @since 2.0
 978:     */
       public static int lastIndexOf(String str, String searchStr, int startPos) 
       {
           if (str == null || searchStr == null) {
             return -1;
         }
         return str.lastIndexOf(searchStr, startPos);
    }
 
     // Contains
     //-----------------------------------------------------------------------
    /**
 989:     * <p>Checks if String contains a search character, handling <code>null</code>.
 990:     * This method uses {@link String#indexOf(int)}.</p>
 991:     *
 992:     * <p>A <code>null</code> or empty ("") String will return <code>false</code>.</p>
 993:     *
 994:     * <pre>
 995:     * StringUtils.contains(null, *)    = false
 996:     * StringUtils.contains("", *)      = false
 997:     * StringUtils.contains("abc", 'a') = true
 998:     * StringUtils.contains("abc", 'z') = false
 999:     * </pre>
1000:     *
1001:     * @param str  the String to check, may be null
1002:     * @param searchChar  the character to find
1003:     * @return true if the String contains the search character,
1004:     *  false if not or <code>null</code> string input
1005:     * @since 2.0
1006:     */
	      public static boolean contains(String str, char searchChar) {
	          if (isEmpty(str)) {
            return false;
        }
        return str.indexOf(searchChar) >= 0;
    }

    /**
1015:     * <p>Checks if String contains a search String, handling <code>null</code>.
1016:     * This method uses {@link String#indexOf(String)}.</p>
1017:     *
1018:     * <p>A <code>null</code> String will return <code>false</code>.</p>
1019:     *
1020:     * <pre>
1021:     * StringUtils.contains(null, *)     = false
1022:     * StringUtils.contains(*, null)     = false
1023:     * StringUtils.contains("", "")      = true
1024:     * StringUtils.contains("abc", "")   = true
1025:     * StringUtils.contains("abc", "a")  = true
1026:     * StringUtils.contains("abc", "z")  = false
1027:     * </pre>
1028:     *
1029:     * @param str  the String to check, may be null
1030:     * @param searchStr  the String to find, may be null
1031:     * @return true if the String contains the search String,
1032:     *  false if not or <code>null</code> string input
1033:     * @since 2.0
1034:     */
	      public static boolean contains(String str, String searchStr) {
	          if (str == null || searchStr == null) {
            return false;
        }
        return str.indexOf(searchStr) >= 0;
    }

    /**
1043:     * <p>Checks if String contains a search String irrespective of case,
1044:     * handling <code>null</code>. This method uses
1045:     * {@link #contains(String, String)}.</p>
1046:     *
1047:     * <p>A <code>null</code> String will return <code>false</code>.</p>
1048:     *
1049:     * <pre>
1050:     * StringUtils.contains(null, *) = false
1051:     * StringUtils.contains(*, null) = false
1052:     * StringUtils.contains("", "") = true
1053:     * StringUtils.contains("abc", "") = true
1054:     * StringUtils.contains("abc", "a") = true
1055:     * StringUtils.contains("abc", "z") = false
1056:     * StringUtils.contains("abc", "A") = true
1057:     * StringUtils.contains("abc", "Z") = false
1058:     * </pre>
1059:     *
1060:     * @param str  the String to check, may be null
1061:     * @param searchStr  the String to find, may be null
1062:     * @return true if the String contains the search String irrespective of
1063:     * case or false if not or <code>null</code> string input
1064:     */
    public static boolean containsIgnoreCase(String str, String searchStr) 
    {
	 if (str == null || searchStr == null) {
            return false;
        }
        return contains(str.toUpperCase(), searchStr.toUpperCase());
    }
    // IndexOfAny chars
    //-----------------------------------------------------------------------
    /**
1075:     * <p>Search a String to find the first index of any
1076:     * character in the given set of characters.</p>
1077:     *
1078:     * <p>A <code>null</code> String will return <code>-1</code>.
1079:     * A <code>null</code> or zero length search array will return <code>-1</code>.</p>
1080:     *
1081:     * <pre>
1082:     * StringUtils.indexOfAny(null, *)                = -1
1083:     * StringUtils.indexOfAny("", *)                  = -1
1084:     * StringUtils.indexOfAny(*, null)                = -1
1085:     * StringUtils.indexOfAny(*, [])                  = -1
1086:     * StringUtils.indexOfAny("zzabyycdxx",['z','a']) = 0
1087:     * StringUtils.indexOfAny("zzabyycdxx",['b','y']) = 3
1088:     * StringUtils.indexOfAny("aba", ['z'])           = -1
1089:     * </pre>
1090:     *
1091:     * @param str  the String to check, may be null
1092:     * @param searchChars  the chars to search for, may be null
1093:     * @return the index of any of the chars, -1 if no match or null input
1094:     * @since 2.0
1095:     */
   /*public static int indexOfAny(String str, char[] searchChars) {
	          if (isEmpty(str) || ArrayUtils.isEmpty(searchChars)) {
            return -1;
        }
	          for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
	              for (int j = 0; j < searchChars.length; j++) {
	                  if (searchChars[j] == ch) {
                    return i;
                }
            }
        }
        return -1;
    }*/
   

    /**
1112:     * <p>Search a String to find the first index of any
1113:     * character in the given set of characters.</p>
1114:     *
1115:     * <p>A <code>null</code> String will return <code>-1</code>.
1116:     * A <code>null</code> search string will return <code>-1</code>.</p>
1117:     *
1118:     * <pre>
1119:     * StringUtils.indexOfAny(null, *)            = -1
1120:     * StringUtils.indexOfAny("", *)              = -1
1121:     * StringUtils.indexOfAny(*, null)            = -1
1122:     * StringUtils.indexOfAny(*, "")              = -1
1123:     * StringUtils.indexOfAny("zzabyycdxx", "za") = 0
1124:     * StringUtils.indexOfAny("zzabyycdxx", "by") = 3
1125:     * StringUtils.indexOfAny("aba","z")          = -1
1126:     * </pre>
1127:     *
1128:     * @param str  the String to check, may be null
1129:     * @param searchChars  the chars to search for, may be null
1130:     * @return the index of any of the chars, -1 if no match or null input
1131:     * @since 2.0
1132:     */
    /*public static int indexOfAny(String str, String searchChars) {
	          if (isEmpty(str) || isEmpty(searchChars)) {
            return -1;
        }
        return indexOfAny(str, searchChars.toCharArray());
    }*/

    // ContainsAny
    //-----------------------------------------------------------------------
    /**
1143:     * <p>Checks if the String contains any character in the given
1144:     * set of characters.</p>
1145:     *
1146:     * <p>A <code>null</code> String will return <code>false</code>.
1147:     * A <code>null</code> or zero length search array will return <code>false</code>.</p>
1148:     *
1149:     * <pre>
1150:     * StringUtils.containsAny(null, *)                = false
1151:     * StringUtils.containsAny("", *)                  = false
1152:     * StringUtils.containsAny(*, null)                = false
1153:     * StringUtils.containsAny(*, [])                  = false
1154:     * StringUtils.containsAny("zzabyycdxx",['z','a']) = true
1155:     * StringUtils.containsAny("zzabyycdxx",['b','y']) = true
1156:     * StringUtils.containsAny("aba", ['z'])           = false
1157:     * </pre>
1158:     *
1159:     * @param str  the String to check, may be null
1160:     * @param searchChars  the chars to search for, may be null
1161:     * @return the <code>true</code> if any of the chars are found,
1162:     * <code>false</code> if no match or null input
1163:     * @since 2.4
1164:     */
   public static boolean containsAny(String str, char[] searchChars) {
	          if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
            return false;
        }
	          for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
	              for (int j = 0; j < searchChars.length; j++) {
	                  if (searchChars[j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
1181:     * <p>
1182:     * Checks if the String contains any character in the given set of characters.
1183:     * </p>
1184:     * 
1185:     * <p>
1186:     * A <code>null</code> String will return <code>false</code>. A <code>null</code> search string will return
1187:     * <code>false</code>.
1188:     * </p>
1189:     * 
1190:     * <pre>
1191:     * StringUtils.containsAny(null, *)            = false
1192:     * StringUtils.containsAny("", *)              = false
1193:     * StringUtils.containsAny(*, null)            = false
1194:     * StringUtils.containsAny(*, "")              = false
1195:     * StringUtils.containsAny("zzabyycdxx", "za") = true
1196:     * StringUtils.containsAny("zzabyycdxx", "by") = true
1197:     * StringUtils.containsAny("aba","z")          = false
1198:     * </pre>
1199:     * 
1200:     * @param str
1201:     *            the String to check, may be null
1202:     * @param searchChars
1203:     *            the chars to search for, may be null
1204:     * @return the <code>true</code> if any of the chars are found, <code>false</code> if no match or null input
1205:     * @since 2.4
1206:     */
    public static boolean containsAny(String str, String searchChars) {
	          if (searchChars == null) {
            return false;
        }
        return containsAny(str, searchChars.toCharArray());
    }

    // IndexOfAnyBut chars
    //-----------------------------------------------------------------------
    /**
1217:     * <p>Search a String to find the first index of any
1218:     * character not in the given set of characters.</p>
1219:     *
1220:     * <p>A <code>null</code> String will return <code>-1</code>.
1221:     * A <code>null</code> or zero length search array will return <code>-1</code>.</p>
1222:     *
1223:     * <pre>
1224:     * StringUtils.indexOfAnyBut(null, *)           = -1
1225:     * StringUtils.indexOfAnyBut("", *)             = -1
1226:     * StringUtils.indexOfAnyBut(*, null)           = -1
1227:     * StringUtils.indexOfAnyBut(*, [])             = -1
1228:     * StringUtils.indexOfAnyBut("zzabyycdxx",'za') = 3
1229:     * StringUtils.indexOfAnyBut("zzabyycdxx", '')  = 0
1230:     * StringUtils.indexOfAnyBut("aba", 'ab')       = -1
1231:     * </pre>
1232:     *
1233:     * @param str  the String to check, may be null
1234:     * @param searchChars  the chars to search for, may be null
1235:     * @return the index of any of the chars, -1 if no match or null input
1236:     * @since 2.0
1237:     */
 /* public static int indexOfAnyBut(String str, char[] searchChars) {
	          if (isEmpty(str) || ArrayUtils.isEmpty(searchChars)) {
            return -1;
        }
	          outer : for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
	              for (int j = 0; j < searchChars.length; j++) {
	                  if (searchChars[j] == ch) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }*/

    /**
1255:     * <p>Search a String to find the first index of any
1256:     * character not in the given set of characters.</p>
1257:     *
1258:     * <p>A <code>null</code> String will return <code>-1</code>.
1259:     * A <code>null</code> search string will return <code>-1</code>.</p>
1260:     *
1261:     * <pre>
1262:     * StringUtils.indexOfAnyBut(null, *)            = -1
1263:     * StringUtils.indexOfAnyBut("", *)              = -1
1264:     * StringUtils.indexOfAnyBut(*, null)            = -1
1265:     * StringUtils.indexOfAnyBut(*, "")              = -1
1266:     * StringUtils.indexOfAnyBut("zzabyycdxx", "za") = 3
1267:     * StringUtils.indexOfAnyBut("zzabyycdxx", "")   = 0
1268:     * StringUtils.indexOfAnyBut("aba","ab")         = -1
1269:     * </pre>
1270:     *
1271:     * @param str  the String to check, may be null
1272:     * @param searchChars  the chars to search for, may be null
1273:     * @return the index of any of the chars, -1 if no match or null input
1274:     * @since 2.0
1275:     */
    public static int indexOfAnyBut(String str, String searchChars) {
	          if (isEmpty(str) || isEmpty(searchChars)) {
            return -1;
        }
	          for (int i = 0; i < str.length(); i++) {
	              if (searchChars.indexOf(str.charAt(i)) < 0) {
                return i;
            }
        }
        return -1;
    }

    // ContainsOnly
    //-----------------------------------------------------------------------
    /**
1291:     * <p>Checks if the String contains only certain characters.</p>
1292:     *
1293:     * <p>A <code>null</code> String will return <code>false</code>.
1294:     * A <code>null</code> valid character array will return <code>false</code>.
1295:     * An empty String ("") always returns <code>true</code>.</p>
1296:     *
1297:     * <pre>
1298:     * StringUtils.containsOnly(null, *)       = false
1299:     * StringUtils.containsOnly(*, null)       = false
1300:     * StringUtils.containsOnly("", *)         = true
1301:     * StringUtils.containsOnly("ab", '')      = false
1302:     * StringUtils.containsOnly("abab", 'abc') = true
1303:     * StringUtils.containsOnly("ab1", 'abc')  = false
1304:     * StringUtils.containsOnly("abz", 'abc')  = false
1305:     * </pre>
1306:     *
1307:     * @param str  the String to check, may be null
1308:     * @param valid  an array of valid chars, may be null
1309:     * @return true if it only contains valid chars and is non-null
1310:     */
 /*public static boolean containsOnly(String str, char[] valid) {
        // All these pre-checks are to maintain API with an older version
	          if ((valid == null) || (str == null)) {
            return false;
        }
	          if (str.length() == 0) {
            return true;
        }
	          if (valid.length == 0) {
            return false;
        }
        return indexOfAnyBut(str, valid) == -1;
    }
*/
    /**
1326:     * <p>Checks if the String contains only certain characters.</p>
1327:     *
1328:     * <p>A <code>null</code> String will return <code>false</code>.
1329:     * A <code>null</code> valid character String will return <code>false</code>.
1330:     * An empty String ("") always returns <code>true</code>.</p>
1331:     *
1332:     * <pre>
1333:     * StringUtils.containsOnly(null, *)       = false
1334:     * StringUtils.containsOnly(*, null)       = false
1335:     * StringUtils.containsOnly("", *)         = true
1336:     * StringUtils.containsOnly("ab", "")      = false
1337:     * StringUtils.containsOnly("abab", "abc") = true
1338:     * StringUtils.containsOnly("ab1", "abc")  = false
1339:     * StringUtils.containsOnly("abz", "abc")  = false
1340:     * </pre>
1341:     *
1342:     * @param str  the String to check, may be null
1343:     * @param validChars  a String of valid chars, may be null
1344:     * @return true if it only contains valid chars and is non-null
1345:     * @since 2.0
1346:     */
   /*public static boolean containsOnly(String str, String validChars) {
	          if (str == null || validChars == null) {
            return false;
        }
        return containsOnly(str, validChars.toCharArray());
    }*/

    // ContainsNone
    //-----------------------------------------------------------------------
    /**
1357:     * <p>Checks that the String does not contain certain characters.</p>
1358:     *
1359:     * <p>A <code>null</code> String will return <code>true</code>.
1360:     * A <code>null</code> invalid character array will return <code>true</code>.
1361:     * An empty String ("") always returns true.</p>
1362:     *
1363:     * <pre>
1364:     * StringUtils.containsNone(null, *)       = true
1365:     * StringUtils.containsNone(*, null)       = true
1366:     * StringUtils.containsNone("", *)         = true
1367:     * StringUtils.containsNone("ab", '')      = true
1368:     * StringUtils.containsNone("abab", 'xyz') = true
1369:     * StringUtils.containsNone("ab1", 'xyz')  = true
1370:     * StringUtils.containsNone("abz", 'xyz')  = false
1371:     * </pre>
1372:     *
1373:     * @param str  the String to check, may be null
1374:     * @param invalidChars  an array of invalid chars, may be null
1375:     * @return true if it contains none of the invalid chars, or is null
1376:     * @since 2.0
1377:     */
  public static boolean containsNone(String str, char[] invalidChars) {
	          if (str == null || invalidChars == null) {
            return true;
        }
        int strSize = str.length();
        int validSize = invalidChars.length;
	          for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);
	              for (int j = 0; j < validSize; j++) {
	                  if (invalidChars[j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
1396:     * <p>Checks that the String does not contain certain characters.</p>
1397:     *
1398:     * <p>A <code>null</code> String will return <code>true</code>.
1399:     * A <code>null</code> invalid character array will return <code>true</code>.
1400:     * An empty String ("") always returns true.</p>
1401:     *
1402:     * <pre>
1403:     * StringUtils.containsNone(null, *)       = true
1404:     * StringUtils.containsNone(*, null)       = true
1405:     * StringUtils.containsNone("", *)         = true
1406:     * StringUtils.containsNone("ab", "")      = true
1407:     * StringUtils.containsNone("abab", "xyz") = true
1408:     * StringUtils.containsNone("ab1", "xyz")  = true
1409:     * StringUtils.containsNone("abz", "xyz")  = false
1410:     * </pre>
1411:     *
1412:     * @param str  the String to check, may be null
1413:     * @param invalidChars  a String of invalid chars, may be null
1414:     * @return true if it contains none of the invalid chars, or is null
1415:     * @since 2.0
1416:     */
   public static boolean containsNone(String str, String invalidChars) {
	          if (str == null || invalidChars == null) {
            return true;
        }
        return containsNone(str, invalidChars.toCharArray());
    }

    // IndexOfAny strings
    //-----------------------------------------------------------------------
    /**
1427:     * <p>Find the first index of any of a set of potential substrings.</p>
1428:     *
1429:     * <p>A <code>null</code> String will return <code>-1</code>.
1430:     * A <code>null</code> or zero length search array will return <code>-1</code>.
1431:     * A <code>null</code> search array entry will be ignored, but a search
1432:     * array containing "" will return <code>0</code> if <code>str</code> is not
1433:     * null. This method uses {@link String#indexOf(String)}.</p>
1434:     *
1435:     * <pre>
1436:     * StringUtils.indexOfAny(null, *)                     = -1
1437:     * StringUtils.indexOfAny(*, null)                     = -1
1438:     * StringUtils.indexOfAny(*, [])                       = -1
1439:     * StringUtils.indexOfAny("zzabyycdxx", ["ab","cd"])   = 2
1440:     * StringUtils.indexOfAny("zzabyycdxx", ["cd","ab"])   = 2
1441:     * StringUtils.indexOfAny("zzabyycdxx", ["mn","op"])   = -1
1442:     * StringUtils.indexOfAny("zzabyycdxx", ["zab","aby"]) = 1
1443:     * StringUtils.indexOfAny("zzabyycdxx", [""])          = 0
1444:     * StringUtils.indexOfAny("", [""])                    = 0
1445:     * StringUtils.indexOfAny("", ["a"])                   = -1
1446:     * </pre>
1447:     *
1448:     * @param str  the String to check, may be null
1449:     * @param searchStrs  the Strings to search for, may be null
1450:     * @return the first index of any of the searchStrs in str, -1 if no match
1451:     */
     public static int indexOfAny(String str, String[] searchStrs) {
	          if ((str == null) || (searchStrs == null)) {
            return -1;
        }
        int sz = searchStrs.length;

        // String's can't have a MAX_VALUEth index.
        int ret = Integer.MAX_VALUE;

        int tmp = 0;
	          for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];
	              if (search == null) {
                continue;
            }
            tmp = str.indexOf(search);
	              if (tmp == -1) {
                continue;
            }

	              if (tmp < ret) {
                ret = tmp;
            }
        }

        return (ret == Integer.MAX_VALUE) ? -1 : ret;
    }

    /**
1481:     * <p>Find the latest index of any of a set of potential substrings.</p>
1482:     *
1483:     * <p>A <code>null</code> String will return <code>-1</code>.
1484:     * A <code>null</code> search array will return <code>-1</code>.
1485:     * A <code>null</code> or zero length search array entry will be ignored,
1486:     * but a search array containing "" will return the length of <code>str</code>
1487:     * if <code>str</code> is not null. This method uses {@link String#indexOf(String)}</p>
1488:     *
1489:     * <pre>
1490:     * StringUtils.lastIndexOfAny(null, *)                   = -1
1491:     * StringUtils.lastIndexOfAny(*, null)                   = -1
1492:     * StringUtils.lastIndexOfAny(*, [])                     = -1
1493:     * StringUtils.lastIndexOfAny(*, [null])                 = -1
1494:     * StringUtils.lastIndexOfAny("zzabyycdxx", ["ab","cd"]) = 6
1495:     * StringUtils.lastIndexOfAny("zzabyycdxx", ["cd","ab"]) = 6
1496:     * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
1497:     * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn","op"]) = -1
1498:     * StringUtils.lastIndexOfAny("zzabyycdxx", ["mn",""])   = 10
1499:     * </pre>
1500:     *
1501:     * @param str  the String to check, may be null
1502:     * @param searchStrs  the Strings to search for, may be null
1503:     * @return the last index of any of the Strings, -1 if no match
1504:     */
 public static int lastIndexOfAny(String str, String[] searchStrs) {
	          if ((str == null) || (searchStrs == null)) {
            return -1;
        }
        int sz = searchStrs.length;
        int ret = -1;
        int tmp = 0;
	          for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];
	              if (search == null) {
                continue;
            }
            tmp = str.lastIndexOf(search);
	      if (tmp > ret) {
                ret = tmp;
            }
        }
        return ret;
    }

    // Substring
    //-----------------------------------------------------------------------
    /**
1528:     * <p>Gets a substring from the specified String avoiding exceptions.</p>
1529:     *
1530:     * <p>A negative start position can be used to start <code>n</code>
1531:     * characters from the end of the String.</p>
1532:     *
1533:     * <p>A <code>null</code> String will return <code>null</code>.
1534:     * An empty ("") String will return "".</p>
1535:     *
1536:     * <pre>
1537:     * StringUtils.substring(null, *)   = null
1538:     * StringUtils.substring("", *)     = ""
1539:     * StringUtils.substring("abc", 0)  = "abc"
1540:     * StringUtils.substring("abc", 2)  = "c"
1541:     * StringUtils.substring("abc", 4)  = ""
1542:     * StringUtils.substring("abc", -2) = "bc"
1543:     * StringUtils.substring("abc", -4) = "abc"
1544:     * </pre>
1545:     *
1546:     * @param str  the String to get the substring from, may be null
1547:     * @param start  the position to start from, negative means
1548:     *  count back from the end of the String by this many characters
1549:     * @return substring from start position, <code>null</code> if null String input
1550:     */
  public static String substring(String str, int start) {
	          if (str == null) {
            return null;
        }

        // handle negatives, which means last n characters
	          if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

	          if (start < 0) {
            start = 0;
        }
	          if (start > str.length()) {
            return EMPTY;
        }

        return str.substring(start);
    }

    /**
1572:     * <p>Gets a substring from the specified String avoiding exceptions.</p>
1573:     *
1574:     * <p>A negative start position can be used to start/end <code>n</code>
1575:     * characters from the end of the String.</p>
1576:     *
1577:     * <p>The returned substring starts with the character in the <code>start</code>
1578:     * position and ends before the <code>end</code> position. All position counting is
1579:     * zero-based -- i.e., to start at the beginning of the string use
1580:     * <code>start = 0</code>. Negative start and end positions can be used to
1581:     * specify offsets relative to the end of the String.</p>
1582:     *
1583:     * <p>If <code>start</code> is not strictly to the left of <code>end</code>, ""
1584:     * is returned.</p>
1585:     *
1586:     * <pre>
1587:     * StringUtils.substring(null, *, *)    = null
1588:     * StringUtils.substring("", * ,  *)    = "";
1589:     * StringUtils.substring("abc", 0, 2)   = "ab"
1590:     * StringUtils.substring("abc", 2, 0)   = ""
1591:     * StringUtils.substring("abc", 2, 4)   = "c"
1592:     * StringUtils.substring("abc", 4, 6)   = ""
1593:     * StringUtils.substring("abc", 2, 2)   = ""
1594:     * StringUtils.substring("abc", -2, -1) = "b"
1595:     * StringUtils.substring("abc", -4, 2)  = "ab"
1596:     * </pre>
1597:     *
1598:     * @param str  the String to get the substring from, may be null
1599:     * @param start  the position to start from, negative means
1600:     *  count back from the end of the String by this many characters
1601:     * @param end  the position to end at (exclusive), negative means
1602:     *  count back from the end of the String by this many characters
1603:     * @return substring from start position to end positon,
1604:     *  <code>null</code> if null String input
1605:     */
     public static String substring(String str, int start, int end) {
	          if (str == null) {
            return null;
        }

        // handle negatives
	          if (end < 0) {
            end = str.length() + end; // remember end is negative
        }
	          if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        // check length next
	          if (end > str.length()) {
            end = str.length();
        }

        // if start is greater than end, return ""
	          if (start > end) {
            return EMPTY;
        }

	          if (start < 0) {
            start = 0;
        }
	          if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    // Left/Right/Mid
    //-----------------------------------------------------------------------
    /**
1642:     * <p>Gets the leftmost <code>len</code> characters of a String.</p>
1643:     *
1644:     * <p>If <code>len</code> characters are not available, or the
1645:     * String is <code>null</code>, the String will be returned without
1646:     * an exception. An exception is thrown if len is negative.</p>
1647:     *
1648:     * <pre>
1649:     * StringUtils.left(null, *)    = null
1650:     * StringUtils.left(*, -ve)     = ""
1651:     * StringUtils.left("", *)      = ""
1652:     * StringUtils.left("abc", 0)   = ""
1653:     * StringUtils.left("abc", 2)   = "ab"
1654:     * StringUtils.left("abc", 4)   = "abc"
1655:     * </pre>
1656:     *
1657:     * @param str  the String to get the leftmost characters from, may be null
1658:     * @param len  the length of the required String, must be zero or positive
1659:     * @return the leftmost characters, <code>null</code> if null String input
1660:     */
 public static String left(String str, int len) {
   if (str == null) {
            return null;
        }
	          if (len < 0) {
            return EMPTY;
        }
	          if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    /**
1675:     * <p>Gets the rightmost <code>len</code> characters of a String.</p>
1676:     *
1677:     * <p>If <code>len</code> characters are not available, or the String
1678:     * is <code>null</code>, the String will be returned without an
1679:     * an exception. An exception is thrown if len is negative.</p>
1680:     *
1681:     * <pre>
1682:     * StringUtils.right(null, *)    = null
1683:     * StringUtils.right(*, -ve)     = ""
1684:     * StringUtils.right("", *)      = ""
1685:     * StringUtils.right("abc", 0)   = ""
1686:     * StringUtils.right("abc", 2)   = "bc"
1687:     * StringUtils.right("abc", 4)   = "abc"
1688:     * </pre>
1689:     *
1690:     * @param str  the String to get the rightmost characters from, may be null
1691:     * @param len  the length of the required String, must be zero or positive
1692:     * @return the rightmost characters, <code>null</code> if null String input
1693:     */
     public static String right(String str, int len) {
	if (str == null) {
            return null;
        }
	          if (len < 0) {
            return EMPTY;
        }
	          if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    /**
1708:     * <p>Gets <code>len</code> characters from the middle of a String.</p>
1709:     *
1710:     * <p>If <code>len</code> characters are not available, the remainder
1711:     * of the String will be returned without an exception. If the
1712:     * String is <code>null</code>, <code>null</code> will be returned.
1713:     * An exception is thrown if len is negative.</p>
1714:     *
1715:     * <pre>
1716:     * StringUtils.mid(null, *, *)    = null
1717:     * StringUtils.mid(*, *, -ve)     = ""
1718:     * StringUtils.mid("", 0, *)      = ""
1719:     * StringUtils.mid("abc", 0, 2)   = "ab"
1720:     * StringUtils.mid("abc", 0, 4)   = "abc"
1721:     * StringUtils.mid("abc", 2, 4)   = "c"
1722:     * StringUtils.mid("abc", 4, 2)   = ""
1723:     * StringUtils.mid("abc", -2, 2)  = "ab"
1724:     * </pre>
1725:     *
1726:     * @param str  the String to get the characters from, may be null
1727:     * @param pos  the position to start from, negative treated as zero
1728:     * @param len  the length of the required String, must be zero or positive
1729:     * @return the middle characters, <code>null</code> if null String input
1730:     */
 public static String mid(String str, int pos, int len) {
	          if (str == null) {
            return null;
        }
	          if (len < 0 || pos > str.length()) {
            return EMPTY;
       }
	          if (pos < 0) {
            pos = 0;
        }
	          if (str.length() <= (pos + len)) {
            return str.substring(pos);
        }
        return str.substring(pos, pos + len);
    }

    // SubStringAfter/SubStringBefore
    //-----------------------------------------------------------------------
    /**
1750:     * <p>Gets the substring before the first occurrence of a separator.
1751:     * The separator is not returned.</p>
1752:     *
1753:     * <p>A <code>null</code> string input will return <code>null</code>.
1754:     * An empty ("") string input will return the empty string.
1755:     * A <code>null</code> separator will return the input string.</p>
1756:     *
1757:     * <pre>
1758:     * StringUtils.substringBefore(null, *)      = null
1759:     * StringUtils.substringBefore("", *)        = ""
1760:     * StringUtils.substringBefore("abc", "a")   = ""
1761:     * StringUtils.substringBefore("abcba", "b") = "a"
1762:     * StringUtils.substringBefore("abc", "c")   = "ab"
1763:     * StringUtils.substringBefore("abc", "d")   = "abc"
1764:     * StringUtils.substringBefore("abc", "")    = ""
1765:     * StringUtils.substringBefore("abc", null)  = "abc"
1766:     * </pre>
1767:     *
1768:     * @param str  the String to get a substring from, may be null
1769:     * @param separator  the String to search for, may be null
1770:     * @return the substring before the first occurrence of the separator,
1771:     *  <code>null</code> if null String input
1772:     * @since 2.0
1773:     */
  public static String substringBefore(String str, String separator) {
	          if (isEmpty(str) || separator == null) {
            return str;
        }
	          if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
	          if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
1789:     * <p>Gets the substring after the first occurrence of a separator.
1790:     * The separator is not returned.</p>
1791:     *
1792:     * <p>A <code>null</code> string input will return <code>null</code>.
1793:     * An empty ("") string input will return the empty string.
1794:     * A <code>null</code> separator will return the empty string if the
1795:     * input string is not <code>null</code>.</p>
1796:     *
1797:     * <pre>
1798:     * StringUtils.substringAfter(null, *)      = null
1799:     * StringUtils.substringAfter("", *)        = ""
1800:     * StringUtils.substringAfter(*, null)      = ""
1801:     * StringUtils.substringAfter("abc", "a")   = "bc"
1802:     * StringUtils.substringAfter("abcba", "b") = "cba"
1803:     * StringUtils.substringAfter("abc", "c")   = ""
1804:     * StringUtils.substringAfter("abc", "d")   = ""
1805:     * StringUtils.substringAfter("abc", "")    = "abc"
1806:     * </pre>
1807:     *
1808:     * @param str  the String to get a substring from, may be null
1809:     * @param separator  the String to search for, may be null
1810:     * @return the substring after the first occurrence of the separator,
1811:     *  <code>null</code> if null String input
1812:     * @since 2.0
1813:     */
 public static String substringAfter(String str, String separator) {
	          if (isEmpty(str)) {
            return str;
        }
	          if (separator == null) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
	          if (pos == -1) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
1829:     * <p>Gets the substring before the last occurrence of a separator.
1830:     * The separator is not returned.</p>
1831:     *
1832:     * <p>A <code>null</code> string input will return <code>null</code>.
1833:     * An empty ("") string input will return the empty string.
1834:     * An empty or <code>null</code> separator will return the input string.</p>
1835:     *
1836:     * <pre>
1837:     * StringUtils.substringBeforeLast(null, *)      = null
1838:     * StringUtils.substringBeforeLast("", *)        = ""
1839:     * StringUtils.substringBeforeLast("abcba", "b") = "abc"
1840:     * StringUtils.substringBeforeLast("abc", "c")   = "ab"
1841:     * StringUtils.substringBeforeLast("a", "a")     = ""
1842:     * StringUtils.substringBeforeLast("a", "z")     = "a"
1843:     * StringUtils.substringBeforeLast("a", null)    = "a"
1844:     * StringUtils.substringBeforeLast("a", "")      = "a"
1845:     * </pre>
1846:     *
1847:     * @param str  the String to get a substring from, may be null
1848:     * @param separator  the String to search for, may be null
1849:     * @return the substring before the last occurrence of the separator,
1850:     *  <code>null</code> if null String input
1851:     * @since 2.0
1852:     */
     public static String substringBeforeLast(String str, String separator) {
	          if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
	          if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
1865:     * <p>Gets the substring after the last occurrence of a separator.
1866:     * The separator is not returned.</p>
1867:     *
1868:     * <p>A <code>null</code> string input will return <code>null</code>.
1869:     * An empty ("") string input will return the empty string.
1870:     * An empty or <code>null</code> separator will return the empty string if
1871:     * the input string is not <code>null</code>.</p>
1872:     *
1873:     * <pre>
1874:     * StringUtils.substringAfterLast(null, *)      = null
1875:     * StringUtils.substringAfterLast("", *)        = ""
1876:     * StringUtils.substringAfterLast(*, "")        = ""
1877:     * StringUtils.substringAfterLast(*, null)      = ""
1878:     * StringUtils.substringAfterLast("abc", "a")   = "bc"
1879:     * StringUtils.substringAfterLast("abcba", "b") = "a"
1880:     * StringUtils.substringAfterLast("abc", "c")   = ""
1881:     * StringUtils.substringAfterLast("a", "a")     = ""
1882:     * StringUtils.substringAfterLast("a", "z")     = ""
1883:     * </pre>
1884:     *
1885:     * @param str  the String to get a substring from, may be null
1886:     * @param separator  the String to search for, may be null
1887:     * @return the substring after the last occurrence of the separator,
1888:     *  <code>null</code> if null String input
1889:     * @since 2.0
1890:     */
   public static String substringAfterLast(String str, String separator) {
	          if (isEmpty(str)) {
            return str;
        }
	          if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
	          if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    // Substring between
    //-----------------------------------------------------------------------
    /**
1908:     * <p>Gets the String that is nested in between two instances of the
1909:     * same String.</p>
1910:     *
1911:     * <p>A <code>null</code> input String returns <code>null</code>.
1912:     * A <code>null</code> tag returns <code>null</code>.</p>
1913:     *
1914:     * <pre>
1915:     * StringUtils.substringBetween(null, *)            = null
1916:     * StringUtils.substringBetween("", "")             = ""
1917:     * StringUtils.substringBetween("", "tag")          = null
1918:     * StringUtils.substringBetween("tagabctag", null)  = null
1919:     * StringUtils.substringBetween("tagabctag", "")    = ""
1920:     * StringUtils.substringBetween("tagabctag", "tag") = "abc"
1921:     * </pre>
1922:     *
1923:     * @param str  the String containing the substring, may be null
1924:     * @param tag  the String before and after the substring, may be null
1925:     * @return the substring, <code>null</code> if no match
1926:     * @since 2.0
1927:     */
   public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
   }

    /**
1933:     * <p>Gets the String that is nested in between two Strings.
1934:     * Only the first match is returned.</p>
1935:     *
1936:     * <p>A <code>null</code> input String returns <code>null</code>.
1937:     * A <code>null</code> open/close returns <code>null</code> (no match).
1938:     * An empty ("") open and close returns an empty string.</p>
1939:     *
1940:     * <pre>
1941:     * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
1942:     * StringUtils.substringBetween(null, *, *)          = null
1943:     * StringUtils.substringBetween(*, null, *)          = null
1944:     * StringUtils.substringBetween(*, *, null)          = null
1945:     * StringUtils.substringBetween("", "", "")          = ""
1946:     * StringUtils.substringBetween("", "", "]")         = null
1947:     * StringUtils.substringBetween("", "[", "]")        = null
1948:     * StringUtils.substringBetween("yabcz", "", "")     = ""
1949:     * StringUtils.substringBetween("yabcz", "y", "z")   = "abc"
1950:     * StringUtils.substringBetween("yabczyabcz", "y", "z")   = "abc"
1951:     * </pre>
1952:     *
1953:     * @param str  the String containing the substring, may be null
1954:     * @param open  the String before the substring, may be null
1955:     * @param close  the String after the substring, may be null
1956:     * @return the substring, <code>null</code> if no match
1957:     * @since 2.0
1958:     */
      public static String substringBetween(String str, String open, String close) {
	          if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
	          if (start != -1) {
            int end = str.indexOf(close, start + open.length());
	              if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
1974:     * <p>Searches a String for substrings delimited by a start and end tag,
1975:     * returning all matching substrings in an array.</p>
1976:     *
1977:     * <p>A <code>null</code> input String returns <code>null</code>.
1978:     * A <code>null</code> open/close returns <code>null</code> (no match).
1979:     * An empty ("") open/close returns <code>null</code> (no match).</p>
1980:     *
1981:     * <pre>
1982:     * StringUtils.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
1983:     * StringUtils.substringsBetween(null, *, *)            = null
1984:     * StringUtils.substringsBetween(*, null, *)            = null
1985:     * StringUtils.substringsBetween(*, *, null)            = null
1986:     * StringUtils.substringsBetween("", "[", "]")          = []
1987:     * </pre>
1988:     *
1989:     * @param str  the String containing the substrings, null returns null, empty returns empty
1990:     * @param open  the String identifying the start of the substring, empty returns null
1991:     * @param close  the String identifying the end of the substring, empty returns null
1992:     * @return a String Array of substrings, or <code>null</code> if no match
1993:     * @since 2.3
1994:     */
     public static String[] substringsBetween(String str, String open, String close) {
	          if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }
        int strLen = str.length();
	          if (strLen == 0) {
            return EMPTY_STRING_ARRAY;
        }
        int closeLen = close.length();
        int openLen = open.length();
        List list = new ArrayList();
        int pos = 0;
	          while (pos < (strLen - closeLen)) {
            int start = str.indexOf(open, pos);
	              if (start < 0) {
                break;
            }
            start += openLen;
            int end = str.indexOf(close, start);
	              if (end < 0) {
                break;
            }
            list.add(str.substring(start, end));
            pos = end + closeLen;
        }
	          if (list.isEmpty()) {
            return null;
        } 
        return (String[]) list.toArray(new String [list.size()]);
    }

    // Nested extraction
    //-----------------------------------------------------------------------
    /**
2029:     * <p>Gets the String that is nested in between two instances of the
2030:     * same String.</p>
2031:     *
2032:     * <p>A <code>null</code> input String returns <code>null</code>.
2033:     * A <code>null</code> tag returns <code>null</code>.</p>
2034:     *
2035:     * <pre>
2036:     * StringUtils.getNestedString(null, *)            = null
2037:     * StringUtils.getNestedString("", "")             = ""
2038:     * StringUtils.getNestedString("", "tag")          = null
2039:     * StringUtils.getNestedString("tagabctag", null)  = null
2040:     * StringUtils.getNestedString("tagabctag", "")    = ""
2041:     * StringUtils.getNestedString("tagabctag", "tag") = "abc"
2042:     * </pre>
2043:     *
2044:     * @param str  the String containing nested-string, may be null
2045:     * @param tag  the String before and after nested-string, may be null
2046:     * @return the nested String, <code>null</code> if no match
2047:     * @deprecated Use the better named {@link #substringBetween(String, String)}.
2048:     *             Method will be removed in Commons Lang 3.0.
2049:     */
      public static String getNestedString(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
2055:     * <p>Gets the String that is nested in between two Strings.
2056:     * Only the first match is returned.</p>
2057:     *
2058:     * <p>A <code>null</code> input String returns <code>null</code>.
2059:     * A <code>null</code> open/close returns <code>null</code> (no match).
2060:     * An empty ("") open/close returns an empty string.</p>
2061:     *
2062:     * <pre>
2063:     * StringUtils.getNestedString(null, *, *)          = null
2064:     * StringUtils.getNestedString("", "", "")          = ""
2065:     * StringUtils.getNestedString("", "", "tag")       = null
2066:     * StringUtils.getNestedString("", "tag", "tag")    = null
2067:     * StringUtils.getNestedString("yabcz", null, null) = null
2068:     * StringUtils.getNestedString("yabcz", "", "")     = ""
2069:     * StringUtils.getNestedString("yabcz", "y", "z")   = "abc"
2070:     * StringUtils.getNestedString("yabczyabcz", "y", "z")   = "abc"
2071:     * </pre>
2072:     *
2073:     * @param str  the String containing nested-string, may be null
2074:     * @param open  the String before nested-string, may be null
2075:     * @param close  the String after nested-string, may be null
2076:     * @return the nested String, <code>null</code> if no match
2077:     * @deprecated Use the better named {@link #substringBetween(String, String, String)}.
2078:     *             Method will be removed in Commons Lang 3.0.
2079:     */
	      public static String getNestedString(String str, String open, String close) {
        return substringBetween(str, open, close);
    }

    // Splitting
    //-----------------------------------------------------------------------
    /**
2087:     * <p>Splits the provided text into an array, using whitespace as the
2088:     * separator.
2089:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
2090:     *
2091:     * <p>The separator is not included in the returned String array.
2092:     * Adjacent separators are treated as one separator.
2093:     * For more control over the split use the StrTokenizer class.</p>
2094:     *
2095:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
2096:     *
2097:     * <pre>
2098:     * StringUtils.split(null)       = null
2099:     * StringUtils.split("")         = []
2100:     * StringUtils.split("abc def")  = ["abc", "def"]
2101:     * StringUtils.split("abc  def") = ["abc", "def"]
2102:     * StringUtils.split(" abc ")    = ["abc"]
2103:     * </pre>
2104:     *
2105:     * @param str  the String to parse, may be null
2106:     * @return an array of parsed Strings, <code>null</code> if null String input
2107:     */
     public static String[] split(String str) {
        return split(str, null, -1);
    }

    /**
2113:     * <p>Splits the provided text into an array, separator specified.
2114:     * This is an alternative to using StringTokenizer.</p>
2115:     *
2116:     * <p>The separator is not included in the returned String array.
2117:     * Adjacent separators are treated as one separator.
2118:     * For more control over the split use the StrTokenizer class.</p>
2119:     *
2120:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
2121:     *
2122:     * <pre>
2123:     * StringUtils.split(null, *)         = null
2124:     * StringUtils.split("", *)           = []
2125:     * StringUtils.split("a.b.c", '.')    = ["a", "b", "c"]
2126:     * StringUtils.split("a..b.c", '.')   = ["a", "b", "c"]
2127:     * StringUtils.split("a:b:c", '.')    = ["a:b:c"]
2128:     * StringUtils.split("a b c", ' ')    = ["a", "b", "c"]
2129:     * </pre>
2130:     *
2131:     * @param str  the String to parse, may be null
2132:     * @param separatorChar  the character used as the delimiter
2133:     * @return an array of parsed Strings, <code>null</code> if null String input
2134:     * @since 2.0
2135:     */
  public static String[] split(String str, char separatorChar) {
        return splitWorker(str, separatorChar, false);
    }

    /**
2141:     * <p>Splits the provided text into an array, separators specified.
2142:     * This is an alternative to using StringTokenizer.</p>
2143:     *
2144:     * <p>The separator is not included in the returned String array.
2145:     * Adjacent separators are treated as one separator.
2146:     * For more control over the split use the StrTokenizer class.</p>
2147:     *
2148:     * <p>A <code>null</code> input String returns <code>null</code>.
2149:     * A <code>null</code> separatorChars splits on whitespace.</p>
2150:     *
2151:     * <pre>
2152:     * StringUtils.split(null, *)         = null
2153:     * StringUtils.split("", *)           = []
2154:     * StringUtils.split("abc def", null) = ["abc", "def"]
2155:     * StringUtils.split("abc def", " ")  = ["abc", "def"]
2156:     * StringUtils.split("abc  def", " ") = ["abc", "def"]
2157:     * StringUtils.split("ab:cd:ef", ":") = ["ab", "cd", "ef"]
2158:     * </pre>
2159:     *
2160:     * @param str  the String to parse, may be null
2161:     * @param separatorChars  the characters used as the delimiters,
2162:     *  <code>null</code> splits on whitespace
2163:     * @return an array of parsed Strings, <code>null</code> if null String input
2164:     */
      public static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }

    /**
2170:     * <p>Splits the provided text into an array with a maximum length,
2171:     * separators specified.</p>
2172:     *
2173:     * <p>The separator is not included in the returned String array.
2174:     * Adjacent separators are treated as one separator.</p>
2175:     *
2176:     * <p>A <code>null</code> input String returns <code>null</code>.
2177:     * A <code>null</code> separatorChars splits on whitespace.</p>
2178:     *
2179:     * <p>If more than <code>max</code> delimited substrings are found, the last
2180:     * returned string includes all characters after the first <code>max - 1</code>
2181:     * returned strings (including separator characters).</p>
2182:     *
2183:     * <pre>
2184:     * StringUtils.split(null, *, *)            = null
2185:     * StringUtils.split("", *, *)              = []
2186:     * StringUtils.split("ab de fg", null, 0)   = ["ab", "cd", "ef"]
2187:     * StringUtils.split("ab   de fg", null, 0) = ["ab", "cd", "ef"]
2188:     * StringUtils.split("ab:cd:ef", ":", 0)    = ["ab", "cd", "ef"]
2189:     * StringUtils.split("ab:cd:ef", ":", 2)    = ["ab", "cd:ef"]
2190:     * </pre>
2191:     *
2192:     * @param str  the String to parse, may be null
2193:     * @param separatorChars  the characters used as the delimiters,
2194:     *  <code>null</code> splits on whitespace
2195:     * @param max  the maximum number of elements to include in the
2196:     *  array. A zero or negative value implies no limit
2197:     * @return an array of parsed Strings, <code>null</code> if null String input
2198:     */
     public static String[] split(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, false);
    }

    /**
2204:     * <p>Splits the provided text into an array, separator string specified.</p>
2205:     *
2206:     * <p>The separator(s) will not be included in the returned String array.
2207:     * Adjacent separators are treated as one separator.</p>
2208:     *
2209:     * <p>A <code>null</code> input String returns <code>null</code>.
2210:     * A <code>null</code> separator splits on whitespace.</p>
2211:     *
2212:     * <pre>
2213:     * StringUtils.splitByWholeSeparator(null, *)               = null
2214:     * StringUtils.splitByWholeSeparator("", *)                 = []
2215:     * StringUtils.splitByWholeSeparator("ab de fg", null)      = ["ab", "de", "fg"]
2216:     * StringUtils.splitByWholeSeparator("ab   de fg", null)    = ["ab", "de", "fg"]
2217:     * StringUtils.splitByWholeSeparator("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
2218:     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
2219:     * </pre>
2220:     *
2221:     * @param str  the String to parse, may be null
2222:     * @param separator  String containing the String to be used as a delimiter,
2223:     *  <code>null</code> splits on whitespace
2224:     * @return an array of parsed Strings, <code>null</code> if null String was input
2225:     */
     public static String[] splitByWholeSeparator(String str, String separator) {
        return splitByWholeSeparatorWorker( str, separator, -1, false ) ;
    }

    /**
2231:     * <p>Splits the provided text into an array, separator string specified.
2232:     * Returns a maximum of <code>max</code> substrings.</p>
2233:     *
2234:     * <p>The separator(s) will not be included in the returned String array.
2235:     * Adjacent separators are treated as one separator.</p>
2236:     *
2237:     * <p>A <code>null</code> input String returns <code>null</code>.
2238:     * A <code>null</code> separator splits on whitespace.</p>
2239:     *
2240:     * <pre>
2241:     * StringUtils.splitByWholeSeparator(null, *, *)               = null
2242:     * StringUtils.splitByWholeSeparator("", *, *)                 = []
2243:     * StringUtils.splitByWholeSeparator("ab de fg", null, 0)      = ["ab", "de", "fg"]
2244:     * StringUtils.splitByWholeSeparator("ab   de fg", null, 0)    = ["ab", "de", "fg"]
2245:     * StringUtils.splitByWholeSeparator("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
2246:     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
2247:     * StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
2248:     * </pre>
2249:     *
2250:     * @param str  the String to parse, may be null
2251:     * @param separator  String containing the String to be used as a delimiter,
2252:     *  <code>null</code> splits on whitespace
2253:     * @param max  the maximum number of elements to include in the returned
2254:     *  array. A zero or negative value implies no limit.
2255:     * @return an array of parsed Strings, <code>null</code> if null String was input
2256:     */
     public static String[] splitByWholeSeparator( String str, String separator, int max ) {
        return splitByWholeSeparatorWorker(str, separator, max, false);
    }

    /**
2262:     * <p>Splits the provided text into an array, separator string specified. </p>
2263:     *
2264:     * <p>The separator is not included in the returned String array.
2265:     * Adjacent separators are treated as separators for empty tokens.
2266:     * For more control over the split use the StrTokenizer class.</p>
2267:     *
2268:     * <p>A <code>null</code> input String returns <code>null</code>.
2269:     * A <code>null</code> separator splits on whitespace.</p>
2270:     *
2271:     * <pre>
2272:     * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *)               = null
2273:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *)                 = []
2274:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null)      = ["ab", "de", "fg"]
2275:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null)    = ["ab", "", "", "de", "fg"]
2276:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":")       = ["ab", "cd", "ef"]
2277:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-") = ["ab", "cd", "ef"]
2278:     * </pre>
2279:     *
2280:     * @param str  the String to parse, may be null
2281:     * @param separator  String containing the String to be used as a delimiter,
2282:     *  <code>null</code> splits on whitespace
2283:     * @return an array of parsed Strings, <code>null</code> if null String was input
2284:     * @since 2.4
2285:     */
     public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        return splitByWholeSeparatorWorker(str, separator, -1, true);
    }

    /**
2291:     * <p>Splits the provided text into an array, separator string specified.
2292:     * Returns a maximum of <code>max</code> substrings.</p>
2293:     *
2294:     * <p>The separator is not included in the returned String array.
2295:     * Adjacent separators are treated as separators for empty tokens.
2296:     * For more control over the split use the StrTokenizer class.</p>
2297:     *
2298:     * <p>A <code>null</code> input String returns <code>null</code>.
2299:     * A <code>null</code> separator splits on whitespace.</p>
2300:     *
2301:     * <pre>
2302:     * StringUtils.splitByWholeSeparatorPreserveAllTokens(null, *, *)               = null
2303:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("", *, *)                 = []
2304:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab de fg", null, 0)      = ["ab", "de", "fg"]
2305:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null, 0)    = ["ab", "", "", "de", "fg"]
2306:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":", 2)       = ["ab", "cd:ef"]
2307:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 5) = ["ab", "cd", "ef"]
2308:     * StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 2) = ["ab", "cd-!-ef"]
2309:     * </pre>
2310:     *
2311:     * @param str  the String to parse, may be null
2312:     * @param separator  String containing the String to be used as a delimiter,
2313:     *  <code>null</code> splits on whitespace
2314:     * @param max  the maximum number of elements to include in the returned
2315:     *  array. A zero or negative value implies no limit.
2316:     * @return an array of parsed Strings, <code>null</code> if null String was input
2317:     * @since 2.4
2318:     */
     public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        return splitByWholeSeparatorWorker(str, separator, max, true);
    }

    /**
2324:     * Performs the logic for the <code>splitByWholeSeparatorPreserveAllTokens</code> methods.
2325:     *
2326:     * @param str  the String to parse, may be <code>null</code>
2327:     * @param separator  String containing the String to be used as a delimiter,
2328:     *  <code>null</code> splits on whitespace
2329:     * @param max  the maximum number of elements to include in the returned
2330:     *  array. A zero or negative value implies no limit.
2331:     * @param preserveAllTokens if <code>true</code>, adjacent separators are
2332:     * treated as empty token separators; if <code>false</code>, adjacent
2333:     * separators are treated as one separator.
2334:     * @return an array of parsed Strings, <code>null</code> if null String input
2335:     * @since 2.4
2336:     */
    private static String[] splitByWholeSeparatorWorker(String str, String separator, int max, 
                                                        boolean preserveAllTokens) 
	      {
	          if (str == null) {
            return null;
        }

        int len = str.length();

	          if (len == 0) {
            return EMPTY_STRING_ARRAY;
        }

	          if ((separator == null) || (EMPTY.equals(separator))) {
            // Split on whitespace.
            return splitWorker(str, null, max, preserveAllTokens);
        }

        int separatorLength = separator.length();

        ArrayList substrings = new ArrayList();
        int numberOfSubstrings = 0;
        int beg = 0;
        int end = 0;
	          while (end < len) {
            end = str.indexOf(separator, beg);

	              if (end > -1) {
	                  if (end > beg) {
                    numberOfSubstrings += 1;

	                      if (numberOfSubstrings == max) {
                        end = len;
                        substrings.add(str.substring(beg));
                    } else {
                        // The following is OK, because String.substring( beg, end ) excludes
                        // the character at the position 'end'.
                        substrings.add(str.substring(beg, end));

                        // Set the starting point for the next search.
                       // The following is equivalent to beg = end + (separatorLength - 1) + 1,
                        // which is the right calculation:
                        beg = end + separatorLength;
                    }
                } else {
                    // We found a consecutive occurrence of the separator, so skip it.
	                      if (preserveAllTokens) {
                        numberOfSubstrings += 1;
	                          if (numberOfSubstrings == max) {
                            end = len;
                            substrings.add(str.substring(beg));
                        } else {
                            substrings.add(EMPTY);
                        }
                    }
                    beg = end + separatorLength;
                }
            } else {
                // String.substring( beg ) goes from 'beg' to the end of the String.
                substrings.add(str.substring(beg));
                end = len;
            }
       }

       return (String[]) substrings.toArray(new String[substrings.size()]);
    }

    // -----------------------------------------------------------------------
    /**
2406:     * <p>Splits the provided text into an array, using whitespace as the
2407:     * separator, preserving all tokens, including empty tokens created by 
2408:     * adjacent separators. This is an alternative to using StringTokenizer.
2409:     * Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
2410:     *
2411:     * <p>The separator is not included in the returned String array.
2412:     * Adjacent separators are treated as separators for empty tokens.
2413:     * For more control over the split use the StrTokenizer class.</p>
2414:     *
2415:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
2416:     *
2417:     * <pre>
2418:     * StringUtils.splitPreserveAllTokens(null)       = null
2419:     * StringUtils.splitPreserveAllTokens("")         = []
2420:     * StringUtils.splitPreserveAllTokens("abc def")  = ["abc", "def"]
2421:     * StringUtils.splitPreserveAllTokens("abc  def") = ["abc", "", "def"]
2422:     * StringUtils.splitPreserveAllTokens(" abc ")    = ["", "abc", ""]
2423:     * </pre>
2424:     *
2425:     * @param str  the String to parse, may be <code>null</code>
2426:     * @return an array of parsed Strings, <code>null</code> if null String input
2427:     * @since 2.1
2428:     */
     public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    /**
2434:     * <p>Splits the provided text into an array, separator specified,
2435:     * preserving all tokens, including empty tokens created by adjacent
2436:     * separators. This is an alternative to using StringTokenizer.</p>
2437:     *
2438:     * <p>The separator is not included in the returned String array.
2439:     * Adjacent separators are treated as separators for empty tokens.
2440:     * For more control over the split use the StrTokenizer class.</p>
2441:     *
2442:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
2443:     *
2444:     * <pre>
2445:     * StringUtils.splitPreserveAllTokens(null, *)         = null
2446:     * StringUtils.splitPreserveAllTokens("", *)           = []
2447:     * StringUtils.splitPreserveAllTokens("a.b.c", '.')    = ["a", "b", "c"]
2448:     * StringUtils.splitPreserveAllTokens("a..b.c", '.')   = ["a", "", "b", "c"]
2449:     * StringUtils.splitPreserveAllTokens("a:b:c", '.')    = ["a:b:c"]
2450:     * StringUtils.splitPreserveAllTokens("a\tb\nc", null) = ["a", "b", "c"]
2451:     * StringUtils.splitPreserveAllTokens("a b c", ' ')    = ["a", "b", "c"]
2452:     * StringUtils.splitPreserveAllTokens("a b c ", ' ')   = ["a", "b", "c", ""]
2453:     * StringUtils.splitPreserveAllTokens("a b c  ", ' ')   = ["a", "b", "c", "", ""]
2454:     * StringUtils.splitPreserveAllTokens(" a b c", ' ')   = ["", a", "b", "c"]
2455:     * StringUtils.splitPreserveAllTokens("  a b c", ' ')  = ["", "", a", "b", "c"]
2456:     * StringUtils.splitPreserveAllTokens(" a b c ", ' ')  = ["", a", "b", "c", ""]
2457:     * </pre>
2458:     *
2459:     * @param str  the String to parse, may be <code>null</code>
2460:     * @param separatorChar  the character used as the delimiter,
2461:     *  <code>null</code> splits on whitespace
2462:     * @return an array of parsed Strings, <code>null</code> if null String input
2463:     * @since 2.1
2464:     */
      public static String[] splitPreserveAllTokens(String str, char separatorChar) {
        return splitWorker(str, separatorChar, true);
    }

    /**
2470:     * Performs the logic for the <code>split</code> and 
2471:     * <code>splitPreserveAllTokens</code> methods that do not return a
2472:     * maximum array length.
2473:     *
2474:     * @param str  the String to parse, may be <code>null</code>
2475:     * @param separatorChar the separate character
2476:     * @param preserveAllTokens if <code>true</code>, adjacent separators are
2477:     * treated as empty token separators; if <code>false</code>, adjacent
2478:     * separators are treated as one separator.
2479:     * @return an array of parsed Strings, <code>null</code> if null String input
2480:     */
     private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)

	if (str == null) {
            return null;
        }
        int len = str.length();
	          if (len == 0) {
            return EMPTY_STRING_ARRAY;
        }
        List list = new ArrayList();
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
	          while (i < len) {
	              if (str.charAt(i) == separatorChar) {
	                  if (match || preserveAllTokens) {
                    list.add(str.substring(start, i));
                    match = false;
                    lastMatch = true;
                }
                start = ++i;
                continue;
            }
            lastMatch = false;
           match = true;
            i++;
       }
	          if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
2516:     * <p>Splits the provided text into an array, separators specified, 
2517:     * preserving all tokens, including empty tokens created by adjacent
2518:     * separators. This is an alternative to using StringTokenizer.</p>
2519:     *
2520:     * <p>The separator is not included in the returned String array.
2521:     * Adjacent separators are treated as separators for empty tokens.
2522:     * For more control over the split use the StrTokenizer class.</p>
2523:     *
2524:     * <p>A <code>null</code> input String returns <code>null</code>.
2525:     * A <code>null</code> separatorChars splits on whitespace.</p>
2526:     *
2527:     * <pre>
2528:     * StringUtils.splitPreserveAllTokens(null, *)           = null
2529:     * StringUtils.splitPreserveAllTokens("", *)             = []
2530:     * StringUtils.splitPreserveAllTokens("abc def", null)   = ["abc", "def"]
2531:     * StringUtils.splitPreserveAllTokens("abc def", " ")    = ["abc", "def"]
2532:     * StringUtils.splitPreserveAllTokens("abc  def", " ")   = ["abc", "", def"]
2533:     * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":")   = ["ab", "cd", "ef"]
2534:     * StringUtils.splitPreserveAllTokens("ab:cd:ef:", ":")  = ["ab", "cd", "ef", ""]
2535:     * StringUtils.splitPreserveAllTokens("ab:cd:ef::", ":") = ["ab", "cd", "ef", "", ""]
2536:     * StringUtils.splitPreserveAllTokens("ab::cd:ef", ":")  = ["ab", "", cd", "ef"]
2537:     * StringUtils.splitPreserveAllTokens(":cd:ef", ":")     = ["", cd", "ef"]
2538:     * StringUtils.splitPreserveAllTokens("::cd:ef", ":")    = ["", "", cd", "ef"]
2539:     * StringUtils.splitPreserveAllTokens(":cd:ef:", ":")    = ["", cd", "ef", ""]
2540:     * </pre>
2541:     *
2542:     * @param str  the String to parse, may be <code>null</code>
2543:     * @param separatorChars  the characters used as the delimiters,
2544:     *  <code>null</code> splits on whitespace
2545:     * @return an array of parsed Strings, <code>null</code> if null String input
2546:     * @since 2.1
2547:     */
     public static String[] splitPreserveAllTokens(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, true);
    }

    /**
2553:     * <p>Splits the provided text into an array with a maximum length,
2554:     * separators specified, preserving all tokens, including empty tokens 
2555:     * created by adjacent separators.</p>
2556:     *
2557:     * <p>The separator is not included in the returned String array.
2558:     * Adjacent separators are treated as separators for empty tokens.
2559:     * Adjacent separators are treated as one separator.</p>
2560:     *
2561:     * <p>A <code>null</code> input String returns <code>null</code>.
2562:     * A <code>null</code> separatorChars splits on whitespace.</p>
2563:     *
2564:     * <p>If more than <code>max</code> delimited substrings are found, the last
2565:     * returned string includes all characters after the first <code>max - 1</code>
2566:     * returned strings (including separator characters).</p>
2567:     *
2568:     * <pre>
2569:     * StringUtils.splitPreserveAllTokens(null, *, *)            = null
2570:     * StringUtils.splitPreserveAllTokens("", *, *)              = []
2571:     * StringUtils.splitPreserveAllTokens("ab de fg", null, 0)   = ["ab", "cd", "ef"]
2572:     * StringUtils.splitPreserveAllTokens("ab   de fg", null, 0) = ["ab", "cd", "ef"]
2573:     * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":", 0)    = ["ab", "cd", "ef"]
2574:     * StringUtils.splitPreserveAllTokens("ab:cd:ef", ":", 2)    = ["ab", "cd:ef"]
2575:     * StringUtils.splitPreserveAllTokens("ab   de fg", null, 2) = ["ab", "  de fg"]
2576:     * StringUtils.splitPreserveAllTokens("ab   de fg", null, 3) = ["ab", "", " de fg"]
2577:     * StringUtils.splitPreserveAllTokens("ab   de fg", null, 4) = ["ab", "", "", "de fg"]
2578:     * </pre>
2579:     *
2580:     * @param str  the String to parse, may be <code>null</code>
2581:     * @param separatorChars  the characters used as the delimiters,
2582:     *  <code>null</code> splits on whitespace
2583:     * @param max  the maximum number of elements to include in the
2584:     *  array. A zero or negative value implies no limit
2585:     * @return an array of parsed Strings, <code>null</code> if null String input
2586:     * @since 2.1
2587:     */
	      public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        return splitWorker(str, separatorChars, max, true);
    }

    /**
2593:     * Performs the logic for the <code>split</code> and 
2594:     * <code>splitPreserveAllTokens</code> methods that return a maximum array 
2595:     * length.
2596:     *
2597:     * @param str  the String to parse, may be <code>null</code>
2598:     * @param separatorChars the separate character
2599:     * @param max  the maximum number of elements to include in the
2600:     *  array. A zero or negative value implies no limit.
2601:     * @param preserveAllTokens if <code>true</code>, adjacent separators are
2602:     * treated as empty token separators; if <code>false</code>, adjacent
2603:     * separators are treated as one separator.
2604:     * @return an array of parsed Strings, <code>null</code> if null String input
2605:     */
	      private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()

	          if (str == null) {
            return null;
        }
        int len = str.length();
	          if (len == 0) {
            return EMPTY_STRING_ARRAY;
       }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
	          if (separatorChars == null) {
            // Null separator means use whitespace
	              while (i < len) {
                  if (Character.isWhitespace(str.charAt(i))) {
	                      if (match || preserveAllTokens) {
                        lastMatch = true;
	                          if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                       list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
	              while (i < len) {
	                  if (str.charAt(i) == sep) {
	                      if (match || preserveAllTokens) {
                        lastMatch = true;
	                          if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            // standard case
	              while (i < len) {
	                  if (separatorChars.indexOf(str.charAt(i)) >= 0) {
	                      if (match || preserveAllTokens) {
                        lastMatch = true;
	                          if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
	          if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
2692:     * <p>Splits a String by Character type as returned by
2693:     * <code>java.lang.Character.getType(char)</code>. Groups of contiguous
2694:     * characters of the same type are returned as complete tokens. 
2695:     * <pre>
2696:     * StringUtils.splitByCharacterType(null)         = null
2697:     * StringUtils.splitByCharacterType("")           = []
2698:     * StringUtils.splitByCharacterType("ab de fg")   = ["ab", " ", "de", " ", "fg"]
2699:     * StringUtils.splitByCharacterType("ab   de fg") = ["ab", "   ", "de", " ", "fg"]
2700:     * StringUtils.splitByCharacterType("ab:cd:ef")   = ["ab", ":", "cd", ":", "ef"]
2701:     * StringUtils.splitByCharacterType("number5")    = ["number", "5"]
2702:     * StringUtils.splitByCharacterType("fooBar")     = ["foo", "B", "ar"]
2703:     * StringUtils.splitByCharacterType("foo200Bar")  = ["foo", "200", "B", "ar"]
2704:     * StringUtils.splitByCharacterType("ASFRules")   = ["ASFR", "ules"]
2705:     * </pre>
2706:     * @param str the String to split, may be <code>null</code>
2707:     * @return an array of parsed Strings, <code>null</code> if null String input
2708:     * @since 2.4
2709:     */
      public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    /**
2715:     * <p>Splits a String by Character type as returned by
2716:     * <code>java.lang.Character.getType(char)</code>. Groups of contiguous
2717:     * characters of the same type are returned as complete tokens, with the
2718:     * following exception: the character of type
2719:     * <code>Character.UPPERCASE_LETTER</code>, if any, immediately
2720:     * preceding a token of type <code>Character.LOWERCASE_LETTER</code>
2721:     * will belong to the following token rather than to the preceding, if any,
2722:     * <code>Character.UPPERCASE_LETTER</code> token. 
2723:     * <pre>
2724:     * StringUtils.splitByCharacterTypeCamelCase(null)         = null
2725:     * StringUtils.splitByCharacterTypeCamelCase("")           = []
2726:     * StringUtils.splitByCharacterTypeCamelCase("ab de fg")   = ["ab", " ", "de", " ", "fg"]
2727:     * StringUtils.splitByCharacterTypeCamelCase("ab   de fg") = ["ab", "   ", "de", " ", "fg"]
2728:     * StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef")   = ["ab", ":", "cd", ":", "ef"]
2729:     * StringUtils.splitByCharacterTypeCamelCase("number5")    = ["number", "5"]
2730:     * StringUtils.splitByCharacterTypeCamelCase("fooBar")     = ["foo", "Bar"]
2731:     * StringUtils.splitByCharacterTypeCamelCase("foo200Bar")  = ["foo", "200", "Bar"]
2732:     * StringUtils.splitByCharacterTypeCamelCase("ASFRules")   = ["ASF", "Rules"]
2733:     * </pre>
2734:     * @param str the String to split, may be <code>null</code>
2735:     * @return an array of parsed Strings, <code>null</code> if null String input
2736:     * @since 2.4
2737:     */
     public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    /**
2743:     * <p>Splits a String by Character type as returned by
2744:     * <code>java.lang.Character.getType(char)</code>. Groups of contiguous
2745:     * characters of the same type are returned as complete tokens, with the
2746:     * following exception: if <code>camelCase</code> is <code>true</code>,
2747:     * the character of type <code>Character.UPPERCASE_LETTER</code>, if any,
2748:     * immediately preceding a token of type <code>Character.LOWERCASE_LETTER</code>
2749:     * will belong to the following token rather than to the preceding, if any,
2750:     * <code>Character.UPPERCASE_LETTER</code> token. 
2751:     * @param str the String to split, may be <code>null</code>
2752:     * @param camelCase whether to use so-called "camel-case" for letter types
2753:     * @return an array of parsed Strings, <code>null</code> if null String input
2754:     * @since 2.4
2755:     */
      private static String[] splitByCharacterType(String str, boolean camelCase) {
	          if (str == null) {
            return null;
        }
	          if (str.length() == 0) {
            return EMPTY_STRING_ARRAY;
        }
        char[] c = str.toCharArray();
        List list = new ArrayList();
        int tokenStart = 0;
        int currentType = Character.getType(c[tokenStart]);
	          for (int pos = tokenStart + 1; pos < c.length; pos++) {
            int type = Character.getType(c[pos]);
	              if (type == currentType) {
                continue;
            }
	              if (camelCase && type == Character.LOWERCASE_LETTER && currentType == Character.UPPERCASE_LETTER) {
                int newTokenStart = pos - 1;
	                  if (newTokenStart != tokenStart) {
                    list.add(new String(c, tokenStart, newTokenStart - tokenStart));
                    tokenStart = newTokenStart;
                }
            } else {
                list.add(new String(c, tokenStart, pos - tokenStart));
                tokenStart = pos;
            }
            currentType = type;
        }
        list.add(new String(c, tokenStart, c.length - tokenStart));
        return (String[]) list.toArray(new String[list.size()]);
    }
    // Joining
    //-----------------------------------------------------------------------
    /**
2791:     * <p>Concatenates elements of an array into a single String.
2792:     * Null objects or empty strings within the array are represented by
2793:     * empty strings.</p>
2794:     *
2795:     * <pre>
2796:     * StringUtils.concatenate(null)            = null
2797:     * StringUtils.concatenate([])              = ""
2798:     * StringUtils.concatenate([null])          = ""
2799:     * StringUtils.concatenate(["a", "b", "c"]) = "abc"
2800:     * StringUtils.concatenate([null, "", "a"]) = "a"
2801:     * </pre>
2802:     *
2803:     * @param array  the array of values to concatenate, may be null
2804:     * @return the concatenated String, <code>null</code> if null array input
2805:     * @deprecated Use the better named {@link #join(Object[])} instead.
2806:     *             Method will be removed in Commons Lang 3.0.
2807:     */
      public static String concatenate(Object[] array) {
        return join(array, null);
    }

    /**
2813:     * <p>Joins the elements of the provided array into a single String
2814:     * containing the provided list of elements.</p>
2815:     *
2816:     * <p>No separator is added to the joined String.
2817:     * Null objects or empty strings within the array are represented by
2818:     * empty strings.</p>
2819:     *
2820:     * <pre>
2821:     * StringUtils.join(null)            = null
2822:     * StringUtils.join([])              = ""
2823:     * StringUtils.join([null])          = ""
2824:     * StringUtils.join(["a", "b", "c"]) = "abc"
2825:     * StringUtils.join([null, "", "a"]) = "a"
2826:     * </pre>
2827:     *
2828:     * @param array  the array of values to join together, may be null
2829:     * @return the joined String, <code>null</code> if null array input
2830:     * @since 2.0
2831:     */
     public static String join(Object[] array) {
        return join(array, null);
    }

    /**
2837:     * <p>Joins the elements of the provided array into a single String
2838:     * containing the provided list of elements.</p>
2839:     *
2840:     * <p>No delimiter is added before or after the list.
2841:     * Null objects or empty strings within the array are represented by
2842:     * empty strings.</p>
2843:     *
2844:     * <pre>
2845:     * StringUtils.join(null, *)               = null
2846:     * StringUtils.join([], *)                 = ""
2847:     * StringUtils.join([null], *)             = ""
2848:     * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
2849:     * StringUtils.join(["a", "b", "c"], null) = "abc"
2850:     * StringUtils.join([null, "", "a"], ';')  = ";;a"
2851:     * </pre>
2852:     *
2853:     * @param array  the array of values to join together, may be null
2854:     * @param separator  the separator character to use
2855:     * @return the joined String, <code>null</code> if null array input
2856:     * @since 2.0
2857:     */
	      public static String join(Object[] array, char separator) {
	          if (array == null) {
            return null;
        }

        return join(array, separator, 0, array.length);
    }

    /**
2867:     * <p>Joins the elements of the provided array into a single String
2868:     * containing the provided list of elements.</p>
2869:     *
2870:     * <p>No delimiter is added before or after the list.
2871:     * Null objects or empty strings within the array are represented by
2872:     * empty strings.</p>
2873:     *
2874:     * <pre>
2875:     * StringUtils.join(null, *)               = null
2876:     * StringUtils.join([], *)                 = ""
2877:     * StringUtils.join([null], *)             = ""
2878:     * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
2879:     * StringUtils.join(["a", "b", "c"], null) = "abc"
2880:     * StringUtils.join([null, "", "a"], ';')  = ";;a"
2881:     * </pre>
2882:     *
2883:     * @param array  the array of values to join together, may be null
2884:     * @param separator  the separator character to use
2885:     * @param startIndex the first index to start joining from.  It is
2886:     * an error to pass in an end index past the end of the array
2887:     * @param endIndex the index to stop joining from (exclusive). It is
2888:     * an error to pass in an end index past the end of the array
2889:     * @return the joined String, <code>null</code> if null array input
2890:     * @since 2.0
2891:     */
     public static String join(Object[] array, char separator, int startIndex, int endIndex) {
	          if (array == null) {
            return null;
       }
        int bufSize = (endIndex - startIndex);
	          if (bufSize <= 0) {
            return EMPTY;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
        StringBuffer buf = new StringBuffer(bufSize);

          for (int i = startIndex; i < endIndex; i++) {
	              if (i > startIndex) {
                buf.append(separator);
            }
	              if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }


    /**
2917:     * <p>Joins the elements of the provided array into a single String
2918:     * containing the provided list of elements.</p>
2919:     *
2920:     * <p>No delimiter is added before or after the list.
2921:     * A <code>null</code> separator is the same as an empty String ("").
2922:     * Null objects or empty strings within the array are represented by
2923:     * empty strings.</p>
2924:     *
2925:     * <pre>
2926:     * StringUtils.join(null, *)                = null
2927:     * StringUtils.join([], *)                  = ""
2928:     * StringUtils.join([null], *)              = ""
2929:     * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
2930:     * StringUtils.join(["a", "b", "c"], null)  = "abc"
2931:     * StringUtils.join(["a", "b", "c"], "")    = "abc"
2932:     * StringUtils.join([null, "", "a"], ',')   = ",,a"
2933:     * </pre>
2934:     *
2935:     * @param array  the array of values to join together, may be null
2936:     * @param separator  the separator character to use, null treated as ""
2937:     * @return the joined String, <code>null</code> if null array input
2938:     */
     public static String join(Object[] array, String separator) {
	          if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }

    /**
2947:     * <p>Joins the elements of the provided array into a single String
2948:     * containing the provided list of elements.</p>
2949:     *
2950:     * <p>No delimiter is added before or after the list.
2951:     * A <code>null</code> separator is the same as an empty String ("").
2952:     * Null objects or empty strings within the array are represented by
2953:     * empty strings.</p>
2954:     *
2955:     * <pre>
2956:     * StringUtils.join(null, *)                = null
2957:     * StringUtils.join([], *)                  = ""
2958:     * StringUtils.join([null], *)              = ""
2959:     * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
2960:     * StringUtils.join(["a", "b", "c"], null)  = "abc"
2961:     * StringUtils.join(["a", "b", "c"], "")    = "abc"
2962:     * StringUtils.join([null, "", "a"], ',')   = ",,a"
2963:     * </pre>
2964:     *
2965:     * @param array  the array of values to join together, may be null
2966:     * @param separator  the separator character to use, null treated as ""
2967:     * @param startIndex the first index to start joining from.  It is
2968:     * an error to pass in an end index past the end of the array
2969:     * @param endIndex the index to stop joining from (exclusive). It is
2970:     * an error to pass in an end index past the end of the array
2971:     * @return the joined String, <code>null</code> if null array input
2972:     */
     public static String join(Object[] array, String separator, int startIndex, int endIndex) {
	          if (array == null) {
            return null;
     }
	          if (separator == null) {
            separator = EMPTY;
        }

        // endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
        //           (Assuming that all Strings are roughly equally long)
        int bufSize = (endIndex - startIndex);
	          if (bufSize <= 0) {
            return EMPTY;
        }

       bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length())
                        + separator.length());

        StringBuffer buf = new StringBuffer(bufSize);

	          for (int i = startIndex; i < endIndex; i++) {
	              if (i > startIndex) {
                buf.append(separator);
            }
	              if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    /**
3005:     * <p>Joins the elements of the provided <code>Iterator</code> into
3006:     * a single String containing the provided elements.</p>
3007:     *
3008:     * <p>No delimiter is added before or after the list. Null objects or empty
3009:     * strings within the iteration are represented by empty strings.</p>
3010:     *
3011:     * <p>See the examples here: {@link #join(Object[],char)}. </p>
3012:     *
3013:     * @param iterator  the <code>Iterator</code> of values to join together, may be null
3014:     * @param separator  the separator character to use
3015:     * @return the joined String, <code>null</code> if null iterator input
3016:     * @since 2.0
3017:     */
   /*  public static String join(Iterator iterator, char separator) {

        // handle null, zero and one elements before building a buffer
	          if (iterator == null) {
            return null;
        }
	          if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
	          if (!iterator.hasNext()) {
            return ObjectUtils.toString(first);
        }
        // two or more elements
        StringBuffer buf = new StringBuffer(256); // Java default is 16, probably too small
	          if (first != null) {
            buf.append(first);
        }

	          while (iterator.hasNext()) {
            buf.append(separator);
            Object obj = iterator.next();
	              if (obj != null) {
                buf.append(obj);
            }
        }

        return buf.toString();
    }
*/
    /**
3050:     * <p>Joins the elements of the provided <code>Iterator</code> into
3051:     * a single String containing the provided elements.</p>
3052:     *
3053:     * <p>No delimiter is added before or after the list.
3054:     * A <code>null</code> separator is the same as an empty String ("").</p>
3055:     *
3056:     * <p>See the examples here: {@link #join(Object[],String)}. </p>
3057:     *
3058:     * @param iterator  the <code>Iterator</code> of values to join together, may be null
3059:     * @param separator  the separator character to use, null treated as ""
3060:     * @return the joined String, <code>null</code> if null iterator input
3061:     */
/*	      public static String join(Iterator iterator, String separator) {

        // handle null, zero and one elements before building a buffer
	          if (iterator == null) {
            return null;
        }
	          if (!iterator.hasNext()) {
           return EMPTY;
        }
        Object first = iterator.next();
	          if (!iterator.hasNext()) {
            return ObjectUtils.toString(first);
        }

        // two or more elements
        StringBuffer buf = new StringBuffer(256); // Java default is 16, probably too small
	          if (first != null) {
            buf.append(first);
        }

	          while (iterator.hasNext()) {
	              if (separator != null) {
                buf.append(separator);
            }
            Object obj = iterator.next();
	              if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }*/

    /**
3095:     * <p>Joins the elements of the provided <code>Collection</code> into
3096:     * a single String containing the provided elements.</p>
3097:     *
3098:     * <p>No delimiter is added before or after the list. Null objects or empty
3099:     * strings within the iteration are represented by empty strings.</p>
3100:     *
3101:     * <p>See the examples here: {@link #join(Object[],char)}. </p>
3102:     *
3103:     * @param collection  the <code>Collection</code> of values to join together, may be null
3104:     * @param separator  the separator character to use
3105:     * @return the joined String, <code>null</code> if null iterator input
3106:     * @since 2.3
3107:     */
 /*public static String join(Collection collection, char separator) {
	          if (collection == null) {
           return null;
        }
        return join(collection.iterator(), separator);
    }
*/
    /**
3116:     * <p>Joins the elements of the provided <code>Collection</code> into
3117:     * a single String containing the provided elements.</p>
3118:     *
3119:     * <p>No delimiter is added before or after the list.
3120:     * A <code>null</code> separator is the same as an empty String ("").</p>
3121:     *
3122:     * <p>See the examples here: {@link #join(Object[],String)}. </p>
3123:     *
3124:     * @param collection  the <code>Collection</code> of values to join together, may be null
3125:     * @param separator  the separator character to use, null treated as ""
3126:     * @return the joined String, <code>null</code> if null iterator input
3127:     * @since 2.3
3128:     */
    /* public static String join(Collection collection, String separator) {
	          if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }
*/
    // Delete
    //-----------------------------------------------------------------------
    /**
3139:     * <p>Deletes all 'space' characters from a String as defined by
3140:     * {@link Character#isSpace(char)}.</p>
3141:     *
3142:     * <p>This is the only StringUtils method that uses the
3143:     * <code>isSpace</code> definition. You are advised to use
3144:     * {@link #deleteWhitespace(String)} instead as whitespace is much
3145:     * better localized.</p>
3146:     *
3147:     * <pre>
3148:     * StringUtils.deleteSpaces(null)           = null
3149:     * StringUtils.deleteSpaces("")             = ""
3150:     * StringUtils.deleteSpaces("abc")          = "abc"
3151:     * StringUtils.deleteSpaces(" \t  abc \n ") = "abc"
3152:     * StringUtils.deleteSpaces("ab  c")        = "abc"
3153:     * StringUtils.deleteSpaces("a\nb\tc     ") = "abc"
3154:     * </pre>
3155:     *
3156:     * <p>Spaces are defined as <code>{' ', '\t', '\r', '\n', '\b'}</code>
3157:     * in line with the deprecated <code>isSpace</code> method.</p>
3158:     *
3159:     * @param str  the String to delete spaces from, may be null
3160:     * @return the String without 'spaces', <code>null</code> if null String input
3161:     * @deprecated Use the better localized {@link #deleteWhitespace(String)}.
3162:     *             Method will be removed in Commons Lang 3.0.
3163:     */
     
  /*public static String delete(String str, String set) {
 	if (clsUtilidades.isEmpty(str) || clsUtilidades.isEmpty(set)) {
             return str;
         }
         String[] strs = new String[1];
         strs[0] = set;
         return delete(str, strs);
    }   
      public static String delete(String str, String[] set) {
 	          if (clsUtilidades.isEmpty(str) || ArrayUtils.isEmpty(set)) {
             return str;
         }
         return modify(str, set, false);
     }
  public static String deleteSpaces(String str) {
	          if (str == null) {
            return null;
        }
        return CharSetUtils.delete(str, " \t\r\n\b");
    }
*/
    /**
3172:     * <p>Deletes all whitespaces from a String as defined by
3173:     * {@link Character#isWhitespace(char)}.</p>
3174:     *
3175:     * <pre>
3176:     * StringUtils.deleteWhitespace(null)         = null
3177:     * StringUtils.deleteWhitespace("")           = ""
3178:     * StringUtils.deleteWhitespace("abc")        = "abc"
3179:     * StringUtils.deleteWhitespace("   ab  c  ") = "abc"
3180:     * </pre>
3181:     *
3182:     * @param str  the String to delete whitespace from, may be null
3183:     * @return the String without whitespaces, <code>null</code> if null String input
3184:     */
      public static String deleteWhitespace(String str) {
	          if (isEmpty(str)) {
            return str;
        }
        int sz = str.length();
        char[] chs = new char[sz];
        int count = 0;
	          for (int i = 0; i < sz; i++) {
	              if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
	          if (count == sz) {
            return str;
        }
        return new String(chs, 0, count);
    }

    // Remove
    //-----------------------------------------------------------------------
    /**
3206:     * <p>Removes a substring only if it is at the begining of a source string,
3207:     * otherwise returns the source string.</p>
3208:     *
3209:     * <p>A <code>null</code> source string will return <code>null</code>.
3210:     * An empty ("") source string will return the empty string.
3211:     * A <code>null</code> search string will return the source string.</p>
3212:     *
3213:     * <pre>
3214:     * StringUtils.removeStart(null, *)      = null
3215:     * StringUtils.removeStart("", *)        = ""
3216:     * StringUtils.removeStart(*, null)      = *
3217:     * StringUtils.removeStart("www.domain.com", "www.")   = "domain.com"
3218:     * StringUtils.removeStart("domain.com", "www.")       = "domain.com"
3219:     * StringUtils.removeStart("www.domain.com", "domain") = "www.domain.com"
3220:     * StringUtils.removeStart("abc", "")    = "abc"
3221:     * </pre>
3222:     *
3223:     * @param str  the source String to search, may be null
3224:     * @param remove  the String to search for and remove, may be null
3225:     * @return the substring with the string removed if found,
3226:     *  <code>null</code> if null String input
3227:     * @since 2.1
3228:     */
public static String removeStart(String str, String remove) {
	          if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
                  if (str.startsWith(remove)){
            return str.substring(remove.length());
        }
        return str;
  }

    /**
3240:     * <p>Case insensitive removal of a substring if it is at the begining of a source string,
3241:     * otherwise returns the source string.</p>
3242:     *
3243:     * <p>A <code>null</code> source string will return <code>null</code>.
3244:     * An empty ("") source string will return the empty string.
3245:     * A <code>null</code> search string will return the source string.</p>
3246:     *
3247:     * <pre>
3248:     * StringUtils.removeStartIgnoreCase(null, *)      = null
3249:     * StringUtils.removeStartIgnoreCase("", *)        = ""
3250:     * StringUtils.removeStartIgnoreCase(*, null)      = *
3251:     * StringUtils.removeStartIgnoreCase("www.domain.com", "www.")   = "domain.com"
3252:     * StringUtils.removeStartIgnoreCase("www.domain.com", "WWW.")   = "domain.com"
3253:     * StringUtils.removeStartIgnoreCase("domain.com", "www.")       = "domain.com"
3254:     * StringUtils.removeStartIgnoreCase("www.domain.com", "domain") = "www.domain.com"
3255:     * StringUtils.removeStartIgnoreCase("abc", "")    = "abc"
3256:     * </pre>
3257:     *
3258:     * @param str  the source String to search, may be null
3259:     * @param remove  the String to search for (case insensitive) and remove, may be null
3260:     * @return the substring with the string removed if found,
3261:     *  <code>null</code> if null String input
3262:     * @since 2.4
3263:     */
     public static String removeStartIgnoreCase(String str, String remove) {
	          if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
	          if (startsWithIgnoreCase(str, remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
3275:     * <p>Removes a substring only if it is at the end of a source string,
3276:     * otherwise returns the source string.</p>
3277:     *
3278:     * <p>A <code>null</code> source string will return <code>null</code>.
3279:     * An empty ("") source string will return the empty string.
3280:     * A <code>null</code> search string will return the source string.</p>
3281:     *
3282:     * <pre>
3283:     * StringUtils.removeEnd(null, *)      = null
3284:     * StringUtils.removeEnd("", *)        = ""
3285:     * StringUtils.removeEnd(*, null)      = *
3286:     * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
3287:     * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
3288:     * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
3289:     * StringUtils.removeEnd("abc", "")    = "abc"
3290:     * </pre>
3291:     *
3292:     * @param str  the source String to search, may be null
3293:     * @param remove  the String to search for and remove, may be null
3294:     * @return the substring with the string removed if found,
3295:     *  <code>null</code> if null String input
3296:     * @since 2.1
3297:     */
   public static String removeEnd(String str, String remove) {
	          if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
	          if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
3309:     * <p>Case insensitive removal of a substring if it is at the end of a source string,
3310:     * otherwise returns the source string.</p>
3311:     *
3312:     * <p>A <code>null</code> source string will return <code>null</code>.
3313:     * An empty ("") source string will return the empty string.
3314:     * A <code>null</code> search string will return the source string.</p>
3315:     *
3316:     * <pre>
3317:     * StringUtils.removeEnd(null, *)      = null
3318:     * StringUtils.removeEnd("", *)        = ""
3319:     * StringUtils.removeEnd(*, null)      = *
3320:     * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com."
3321:     * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
3322:     * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
3323:     * StringUtils.removeEnd("abc", "")    = "abc"
3324:     * </pre>
3325:     *
3326:     * @param str  the source String to search, may be null
3327:     * @param remove  the String to search for (case insensitive) and remove, may be null
3328:     * @return the substring with the string removed if found,
3329:     *  <code>null</code> if null String input
3330:     * @since 2.4
3331:     */
    public static String removeEndIgnoreCase(String str, String remove) {
	          if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
	          if (endsWithIgnoreCase(str, remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
3343:     * <p>Removes all occurrences of a substring from within the source string.</p>
3344:     *
3345:     * <p>A <code>null</code> source string will return <code>null</code>.
3346:     * An empty ("") source string will return the empty string.
3347:     * A <code>null</code> remove string will return the source string.
3348:     * An empty ("") remove string will return the source string.</p>
3349:     *
3350:     * <pre>
3351:     * StringUtils.remove(null, *)        = null
3352:     * StringUtils.remove("", *)          = ""
3353:     * StringUtils.remove(*, null)        = *
3354:     * StringUtils.remove(*, "")          = *
3355:     * StringUtils.remove("queued", "ue") = "qd"
3356:     * StringUtils.remove("queued", "zz") = "queued"
3357:     * </pre>
3358:     *
3359:     * @param str  the source String to search, may be null
3360:     * @param remove  the String to search for and remove, may be null
3361:     * @return the substring with the string removed if found,
3362:     *  <code>null</code> if null String input
3363:     * @since 2.1
3364:     */
    public static String remove(String str, String remove) {
	          if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        return replace(str, remove, EMPTY, -1);
    }

    /**
3373:     * <p>Removes all occurrences of a character from within the source string.</p>
3374:     *
3375:     * <p>A <code>null</code> source string will return <code>null</code>.
3376:     * An empty ("") source string will return the empty string.</p>
3377:     *
3378:     * <pre>
3379:     * StringUtils.remove(null, *)       = null
3380:     * StringUtils.remove("", *)         = ""
3381:     * StringUtils.remove("queued", 'u') = "qeed"
3382:     * StringUtils.remove("queued", 'z') = "queued"
3383:     * </pre>
3384:     *
3385:     * @param str  the source String to search, may be null
3386:     * @param remove  the char to search for and remove, may be null
3387:     * @return the substring with the char removed if found,
3388:     *  <code>null</code> if null String input
3389:     * @since 2.1
3390:     */
      public static String remove(String str, char remove) {
	          if (isEmpty(str) || str.indexOf(remove) == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
	          for (int i = 0; i < chars.length; i++) {
	              if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

    // Replacing
    //-----------------------------------------------------------------------
    /**
3408:     * <p>Replaces a String with another String inside a larger String, once.</p>
3409:     *
3410:     * <p>A <code>null</code> reference passed to this method is a no-op.</p>
3411:     *
3412:     * <pre>
3413:     * StringUtils.replaceOnce(null, *, *)        = null
3414:     * StringUtils.replaceOnce("", *, *)          = ""
3415:     * StringUtils.replaceOnce("any", null, *)    = "any"
3416:     * StringUtils.replaceOnce("any", *, null)    = "any"
3417:     * StringUtils.replaceOnce("any", "", *)      = "any"
3418:     * StringUtils.replaceOnce("aba", "a", null)  = "aba"
3419:     * StringUtils.replaceOnce("aba", "a", "")    = "ba"
3420:     * StringUtils.replaceOnce("aba", "a", "z")   = "zba"
3421:     * </pre>
3422:     *
3423:     * @see #replace(String text, String searchString, String replacement, int max)
3424:     * @param text  text to search and replace in, may be null
3425:     * @param searchString  the String to search for, may be null
3426:     * @param replacement  the String to replace with, may be null
3427:     * @return the text with any replacements processed,
3428:     *  <code>null</code> if null String input
3429:     */
     public static String replaceOnce(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, 1);
    }

    /**
3435:     * <p>Replaces all occurrences of a String within another String.</p>
3436:     *
3437:     * <p>A <code>null</code> reference passed to this method is a no-op.</p>
3438:     *
3439:     * <pre>
3440:     * StringUtils.replace(null, *, *)        = null
3441:     * StringUtils.replace("", *, *)          = ""
3442:     * StringUtils.replace("any", null, *)    = "any"
3443:     * StringUtils.replace("any", *, null)    = "any"
3444:     * StringUtils.replace("any", "", *)      = "any"
3445:     * StringUtils.replace("aba", "a", null)  = "aba"
3446:     * StringUtils.replace("aba", "a", "")    = "b"
3447:     * StringUtils.replace("aba", "a", "z")   = "zbz"
3448:     * </pre>
3449:     *
3450:     * @see #replace(String text, String searchString, String replacement, int max)
3451:     * @param text  text to search and replace in, may be null
3452:     * @param searchString  the String to search for, may be null
3453:     * @param replacement  the String to replace it with, may be null
3454:     * @return the text with any replacements processed,
3455:     *  <code>null</code> if null String input
3456:     */
      public static String replace(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    /**
3462:     * <p>Replaces a String with another String inside a larger String,
3463:     * for the first <code>max</code> values of the search String.</p>
3464:     *
3465:     * <p>A <code>null</code> reference passed to this method is a no-op.</p>
3466:     *
3467:     * <pre>
3468:     * StringUtils.replace(null, *, *, *)         = null
3469:     * StringUtils.replace("", *, *, *)           = ""
3470:     * StringUtils.replace("any", null, *, *)     = "any"
3471:     * StringUtils.replace("any", *, null, *)     = "any"
3472:     * StringUtils.replace("any", "", *, *)       = "any"
3473:     * StringUtils.replace("any", *, *, 0)        = "any"
3474:     * StringUtils.replace("abaa", "a", null, -1) = "abaa"
3475:     * StringUtils.replace("abaa", "a", "", -1)   = "b"
3476:     * StringUtils.replace("abaa", "a", "z", 0)   = "abaa"
3477:     * StringUtils.replace("abaa", "a", "z", 1)   = "zbaa"
3478:     * StringUtils.replace("abaa", "a", "z", 2)   = "zbza"
3479:     * StringUtils.replace("abaa", "a", "z", -1)  = "zbzz"
3480:     * </pre>
3481:     *
3482:     * @param text  text to search and replace in, may be null
3483:     * @param searchString  the String to search for, may be null
3484:     * @param replacement  the String to replace it with, may be null
3485:     * @param max  maximum number of values to replace, or <code>-1</code> if no maximum
3486:     * @return the text with any replacements processed,
3487:     *  <code>null</code> if null String input
3488:     */
    public static String replace(String text, String searchString, String replacement, int max) {
	          if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0) {
            return text;
        }
        int start = 0;
        int end = text.indexOf(searchString, start);
	          if (end == -1) {
            return text;
        }
        int replLength = searchString.length();
        int increase = replacement.length() - replLength;
        increase = (increase < 0 ? 0 : increase);
        increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
        StringBuffer buf = new StringBuffer(text.length() + increase);
	          while (end != -1) {
            buf.append(text.substring(start, end)).append(replacement);
            start = end + replLength;
	              if (--max == 0) {
                break;
            }
            end = text.indexOf(searchString, start);
        }
        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
3516:     * <p>
3517:     * Replaces all occurrences of Strings within another String.
3518:     * </p>
3519:     * 
3520:     * <p>
3521:     * A <code>null</code> reference passed to this method is a no-op, or if
3522:     * any "search string" or "string to replace" is null, that replace will be
3523:     * ignored. This will not repeat. For repeating replaces, call the
3524:     * overloaded method.
3525:     * </p>
3526:     * 
3527:     * <pre>
3528:     *  StringUtils.replaceEach(null, *, *)        = null
3529:     *  StringUtils.replaceEach("", *, *)          = ""
3530:     *  StringUtils.replaceEach("aba", null, null) = "aba"
3531:     *  StringUtils.replaceEach("aba", new String[0], null) = "aba"
3532:     *  StringUtils.replaceEach("aba", null, new String[0]) = "aba"
3533:     *  StringUtils.replaceEach("aba", new String[]{"a"}, null)  = "aba"
3534:     *  StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""})  = "b"
3535:     *  StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"})  = "aba"
3536:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"})  = "wcte"
3537:     *  (example of how it does not repeat)
3538:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"})  = "dcte"
3539:     * </pre>
3540:     * 
3541:     * @param text
3542:     *            text to search and replace in, no-op if null
3543:     * @param searchList
3544:     *            the Strings to search for, no-op if null
3545:     * @param replacementList
3546:     *            the Strings to replace them with, no-op if null
3547:     * @return the text with any replacements processed, <code>null</code> if
3548:     *         null String input
3549:     * @throws IndexOutOfBoundsException
3550:     *             if the lengths of the arrays are not the same (null is ok,
3551:     *             and/or size 0)
3552:     * @since 2.4
3553:     */
     public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        return replaceEach(text, searchList, replacementList, false, 0);
    }

    /**
3559:     * <p>
3560:     * Replaces all occurrences of Strings within another String.
3561:     * </p>
3562:     * 
3563:     * <p>
3564:     * A <code>null</code> reference passed to this method is a no-op, or if
3565:     * any "search string" or "string to replace" is null, that replace will be
3566:     * ignored. This will not repeat. For repeating replaces, call the
3567:     * overloaded method.
3568:     * </p>
3569:     * 
3570:     * <pre>
3571:     *  StringUtils.replaceEach(null, *, *, *) = null
3572:     *  StringUtils.replaceEach("", *, *, *) = ""
3573:     *  StringUtils.replaceEach("aba", null, null, *) = "aba"
3574:     *  StringUtils.replaceEach("aba", new String[0], null, *) = "aba"
3575:     *  StringUtils.replaceEach("aba", null, new String[0], *) = "aba"
3576:     *  StringUtils.replaceEach("aba", new String[]{"a"}, null, *) = "aba"
3577:     *  StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""}, *) = "b"
3578:     *  StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"}, *) = "aba"
3579:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}, *) = "wcte"
3580:     *  (example of how it repeats)
3581:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, false) = "dcte"
3582:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, true) = "tcte"
3583:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, true) = IllegalArgumentException
3584:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, false) = "dcabe"
3585:     * </pre>
3586:     * 
3587:     * @param text
3588:     *            text to search and replace in, no-op if null
3589:     * @param searchList
3590:     *            the Strings to search for, no-op if null
3591:     * @param replacementList
3592:     *            the Strings to replace them with, no-op if null
3593:     * @return the text with any replacements processed, <code>null</code> if
3594:     *         null String input
3595:     * @throws IllegalArgumentException
3596:     *             if the search is repeating and there is an endless loop due
3597:     *             to outputs of one being inputs to another
3598:     * @throws IndexOutOfBoundsException
3599:     *             if the lengths of the arrays are not the same (null is ok,
3600:     *             and/or size 0)
3601:     * @since 2.4
3602:     */
public static String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        // timeToLive should be 0 if not used or nothing to replace, else it's
        // the length of the replace array
        int timeToLive = searchList == null ? 0 : searchList.length;
        return replaceEach(text, searchList, replacementList, true, timeToLive);
    }

    /**
3611:     * <p>
3612:     * Replaces all occurrences of Strings within another String.
3613:     * </p>
3614:     * 
3615:     * <p>
3616:     * A <code>null</code> reference passed to this method is a no-op, or if
3617:     * any "search string" or "string to replace" is null, that replace will be
3618:     * ignored. 
3619:     * </p>
3620:     * 
3621:     * <pre>
3622:     *  StringUtils.replaceEach(null, *, *, *) = null
3623:     *  StringUtils.replaceEach("", *, *, *) = ""
3624:     *  StringUtils.replaceEach("aba", null, null, *) = "aba"
3625:     *  StringUtils.replaceEach("aba", new String[0], null, *) = "aba"
3626:     *  StringUtils.replaceEach("aba", null, new String[0], *) = "aba"
3627:     *  StringUtils.replaceEach("aba", new String[]{"a"}, null, *) = "aba"
3628:     *  StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{""}, *) = "b"
3629:     *  StringUtils.replaceEach("aba", new String[]{null}, new String[]{"a"}, *) = "aba"
3630:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}, *) = "wcte"
3631:     *  (example of how it repeats)
3632:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, false) = "dcte"
3633:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}, true) = "tcte"
3634:     *  StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "ab"}, *) = IllegalArgumentException
3635:     * </pre>
3636:     * 
3637:     * @param text
3638:     *            text to search and replace in, no-op if null
3639:     * @param searchList
3640:     *            the Strings to search for, no-op if null
3641:     * @param replacementList
3642:     *            the Strings to replace them with, no-op if null
3643:     * @param repeat if true, then replace repeatedly 
3644:     *       until there are no more possible replacements or timeToLive < 0
3645:     * @param timeToLive
3646:     *            if less than 0 then there is a circular reference and endless
3647:     *            loop
3648:     * @return the text with any replacements processed, <code>null</code> if
3649:     *         null String input
3650:     * @throws IllegalArgumentException
3651:     *             if the search is repeating and there is an endless loop due
3652:     *             to outputs of one being inputs to another
3653:     * @throws IndexOutOfBoundsException
3654:     *             if the lengths of the arrays are not the same (null is ok,
3655:     *             and/or size 0)
3656:     * @since 2.4
3657:     */
    private static String replaceEach(String text, String[] searchList, String[] replacementList, 
                                      boolean repeat, int timeToLive) 
	      {

        // mchyzer Performance note: This creates very few new objects (one major goal)
        // let me know if there are performance requests, we can create a harness to measure

        if (text == null || text.length() == 0 || searchList == null || 
            searchList.length == 0 || replacementList == null || replacementList.length == 0) 
	          {
            return text;
        }

        // if recursing, this shouldnt be less than 0
	          if (timeToLive < 0) {
            throw new IllegalStateException("TimeToLive of " + timeToLive + " is less than 0: " + text);
        }

        int searchLength = searchList.length;
        int replacementLength = replacementList.length;

        // make sure lengths are ok, these need to be equal
	          if (searchLength != replacementLength) {
            throw new IllegalArgumentException("Search and Replace array lengths don't match: "
                + searchLength
                + " vs "
                + replacementLength);
        }

        // keep track of which still have matches
        boolean[] noMoreMatchesForReplIndex = new boolean[searchLength];

        // index on index that the match was found
        int textIndex = -1;
        int replaceIndex = -1;
        int tempIndex = -1;

        // index of replace array that will replace the search string found
        // NOTE: logic duplicated below START
	          for (int i = 0; i < searchLength; i++) {
            if (noMoreMatchesForReplIndex[i] || searchList[i] == null || 
                searchList[i].length() == 0 || replacementList[i] == null) 
	              {
                continue;
            }
            tempIndex = text.indexOf(searchList[i]);

            // see if we need to keep searching for this
	              if (tempIndex == -1) {
                noMoreMatchesForReplIndex[i] = true;
            } else {
	                  if (textIndex == -1 || tempIndex < textIndex) {
                    textIndex = tempIndex;
                    replaceIndex = i;
                }
            }
        }
        // NOTE: logic mostly below END

        // no search strings found, we are done
	          if (textIndex == -1) {
            return text;
        }

        int start = 0;

        // get a good guess on the size of the result buffer so it doesnt have to double if it goes over a bit
        int increase = 0;

        // count the replacement text elements that are larger than their corresponding text being replaced
	          for (int i = 0; i < searchList.length; i++) {
            int greater = replacementList[i].length() - searchList[i].length();
	              if (greater > 0) {
                increase += 3 * greater; // assume 3 matches
            }
        }
        // have upper-bound at 20% increase, then let Java take over
        increase = Math.min(increase, text.length() / 5);

        StringBuffer buf = new StringBuffer(text.length() + increase);

	          while (textIndex != -1) {

	              for (int i = start; i < textIndex; i++) {
                buf.append(text.charAt(i));
            }
            buf.append(replacementList[replaceIndex]);

            start = textIndex + searchList[replaceIndex].length();

            textIndex = -1;
            replaceIndex = -1;
            tempIndex = -1;
            // find the next earliest match
            // NOTE: logic mostly duplicated above START
	              for (int i = 0; i < searchLength; i++) {
                if (noMoreMatchesForReplIndex[i] || searchList[i] == null || 
                    searchList[i].length() == 0 || replacementList[i] == null) 
	                  {
                    continue;
                }
                tempIndex = text.indexOf(searchList[i], start);

                // see if we need to keep searching for this
	                  if (tempIndex == -1) {
                    noMoreMatchesForReplIndex[i] = true;
                } else {
	                      if (textIndex == -1 || tempIndex < textIndex) {
                        textIndex = tempIndex;
                        replaceIndex = i;
                    }
                }
            }
            // NOTE: logic duplicated above END

        }
        int textLength = text.length();
	          for (int i = start; i < textLength; i++) {
            buf.append(text.charAt(i));
        }
        String result = buf.toString();
	          if (!repeat) {
            return result;
        }

        return replaceEach(result, searchList, replacementList, repeat, timeToLive - 1);
    }

    // Replace, character based
    //-----------------------------------------------------------------------
    /**
3789:     * <p>Replaces all occurrences of a character in a String with another.
3790:     * This is a null-safe version of {@link String#replace(char, char)}.</p>
3791:     *
3792:     * <p>A <code>null</code> string input returns <code>null</code>.
3793:     * An empty ("") string input returns an empty string.</p>
3794:     *
3795:     * <pre>
3796:     * StringUtils.replaceChars(null, *, *)        = null
3797:     * StringUtils.replaceChars("", *, *)          = ""
3798:     * StringUtils.replaceChars("abcba", 'b', 'y') = "aycya"
3799:     * StringUtils.replaceChars("abcba", 'z', 'y') = "abcba"
3800:     * </pre>
3801:     *
3802:     * @param str  String to replace characters in, may be null
3803:     * @param searchChar  the character to search for, may be null
3804:     * @param replaceChar  the character to replace, may be null
3805:     * @return modified String, <code>null</code> if null string input
3806:     * @since 2.0
3807:     */
     public static String replaceChars(String str, char searchChar, char replaceChar) {
	          if (str == null) {
            return null;
        }
        return str.replace(searchChar, replaceChar);
    }

    /**
3816:     * <p>Replaces multiple characters in a String in one go.
3817:     * This method can also be used to delete characters.</p>
3818:     *
3819:     * <p>For example:<br />
3820:     * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>.</p>
3821:     *
3822:     * <p>A <code>null</code> string input returns <code>null</code>.
3823:     * An empty ("") string input returns an empty string.
3824:     * A null or empty set of search characters returns the input string.</p>
3825:     *
3826:     * <p>The length of the search characters should normally equal the length
3827:     * of the replace characters.
3828:     * If the search characters is longer, then the extra search characters
3829:     * are deleted.
3830:     * If the search characters is shorter, then the extra replace characters
3831:     * are ignored.</p>
3832:     *
3833:     * <pre>
3834:     * StringUtils.replaceChars(null, *, *)           = null
3835:     * StringUtils.replaceChars("", *, *)             = ""
3836:     * StringUtils.replaceChars("abc", null, *)       = "abc"
3837:     * StringUtils.replaceChars("abc", "", *)         = "abc"
3838:     * StringUtils.replaceChars("abc", "b", null)     = "ac"
3839:     * StringUtils.replaceChars("abc", "b", "")       = "ac"
3840:     * StringUtils.replaceChars("abcba", "bc", "yz")  = "ayzya"
3841:     * StringUtils.replaceChars("abcba", "bc", "y")   = "ayya"
3842:     * StringUtils.replaceChars("abcba", "bc", "yzx") = "ayzya"
3843:     * </pre>
3844:     *
3845:     * @param str  String to replace characters in, may be null
3846:     * @param searchChars  a set of characters to search for, may be null
3847:     * @param replaceChars  a set of characters to replace, may be null
3848:     * @return modified String, <code>null</code> if null string input
3849:     * @since 2.0
3850:     */
     public static String replaceChars(String str, String searchChars, String replaceChars) {
	 if (isEmpty(str) || isEmpty(searchChars)) {
            return str;
        }
	  if (replaceChars == null) {
            replaceChars = EMPTY;
        }
        boolean modified = false;
        int replaceCharsLength = replaceChars.length();
        int strLength = str.length();
        StringBuffer buf = new StringBuffer(strLength);
	          for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            int index = searchChars.indexOf(ch);
	              if (index >= 0) {
                modified = true;
	                  if (index < replaceCharsLength) {
                    buf.append(replaceChars.charAt(index));
                }
            } else {
                buf.append(ch);
            }
        }
	          if (modified) {
            return buf.toString();
        }
        return str;
    }

    // Overlay
    //-----------------------------------------------------------------------
    /**
3883:     * <p>Overlays part of a String with another String.</p>
3884:     *
3885:     * <pre>
3886:     * StringUtils.overlayString(null, *, *, *)           = NullPointerException
3887:     * StringUtils.overlayString(*, null, *, *)           = NullPointerException
3888:     * StringUtils.overlayString("", "abc", 0, 0)         = "abc"
3889:     * StringUtils.overlayString("abcdef", null, 2, 4)    = "abef"
3890:     * StringUtils.overlayString("abcdef", "", 2, 4)      = "abef"
3891:     * StringUtils.overlayString("abcdef", "zzzz", 2, 4)  = "abzzzzef"
3892:     * StringUtils.overlayString("abcdef", "zzzz", 4, 2)  = "abcdzzzzcdef"
3893:     * StringUtils.overlayString("abcdef", "zzzz", -1, 4) = IndexOutOfBoundsException
3894:     * StringUtils.overlayString("abcdef", "zzzz", 2, 8)  = IndexOutOfBoundsException
3895:     * </pre>
3896:     *
3897:     * @param text  the String to do overlaying in, may be null
3898:     * @param overlay  the String to overlay, may be null
3899:     * @param start  the position to start overlaying at, must be valid
3900:     * @param end  the position to stop overlaying before, must be valid
3901:     * @return overlayed String, <code>null</code> if null String input
3902:     * @throws NullPointerException if text or overlay is null
3903:     * @throws IndexOutOfBoundsException if either position is invalid
3904:     * @deprecated Use better named {@link #overlay(String, String, int, int)} instead.
3905:     *             Method will be removed in Commons Lang 3.0.
3906:     */
 public static String overlayString(String text, String overlay, int start, int end) {
        return new StringBuffer(start + overlay.length() + text.length() - end + 1)
            .append(text.substring(0, start))
            .append(overlay)
            .append(text.substring(end))
            .toString();
    }

    /**
3916:     * <p>Overlays part of a String with another String.</p>
3917:     *
3918:     * <p>A <code>null</code> string input returns <code>null</code>.
3919:     * A negative index is treated as zero.
3920:     * An index greater than the string length is treated as the string length.
3921:     * The start index is always the smaller of the two indices.</p>
3922:     *
3923:     * <pre>
3924:     * StringUtils.overlay(null, *, *, *)            = null
3925:     * StringUtils.overlay("", "abc", 0, 0)          = "abc"
3926:     * StringUtils.overlay("abcdef", null, 2, 4)     = "abef"
3927:     * StringUtils.overlay("abcdef", "", 2, 4)       = "abef"
3928:     * StringUtils.overlay("abcdef", "", 4, 2)       = "abef"
3929:     * StringUtils.overlay("abcdef", "zzzz", 2, 4)   = "abzzzzef"
3930:     * StringUtils.overlay("abcdef", "zzzz", 4, 2)   = "abzzzzef"
3931:     * StringUtils.overlay("abcdef", "zzzz", -1, 4)  = "zzzzef"
3932:     * StringUtils.overlay("abcdef", "zzzz", 2, 8)   = "abzzzz"
3933:     * StringUtils.overlay("abcdef", "zzzz", -2, -3) = "zzzzabcdef"
3934:     * StringUtils.overlay("abcdef", "zzzz", 8, 10)  = "abcdefzzzz"
3935:     * </pre>
3936:     *
3937:     * @param str  the String to do overlaying in, may be null
3938:     * @param overlay  the String to overlay, may be null
3939:     * @param start  the position to start overlaying at
3940:     * @param end  the position to stop overlaying before
3941:     * @return overlayed String, <code>null</code> if null String input
3942:     * @since 2.0
3943:     */
	      public static String overlay(String str, String overlay, int start, int end) {
	          if (str == null) {
            return null;
        }
	          if (overlay == null) {
            overlay = EMPTY;
        }
        int len = str.length();
	          if (start < 0) {
            start = 0;
        }
	          if (start > len) {
            start = len;
        }
	          if (end < 0) {
            end = 0;
        }
	          if (end > len) {
            end = len;
        }
	          if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        return new StringBuffer(len + start - end + overlay.length() + 1)
            .append(str.substring(0, start))
            .append(overlay)
            .append(str.substring(end))
            .toString();
    }

    // Chomping
    //-----------------------------------------------------------------------
    /**
3979:     * <p>Removes one newline from end of a String if it's there,
3980:     * otherwise leave it alone.  A newline is &quot;<code>\n</code>&quot;,
3981:     * &quot;<code>\r</code>&quot;, or &quot;<code>\r\n</code>&quot;.</p>
3982:     *
3983:     * <p>NOTE: This method changed in 2.0.
3984:     * It now more closely matches Perl chomp.</p>
3985:     *
3986:     * <pre>
3987:     * StringUtils.chomp(null)          = null
3988:     * StringUtils.chomp("")            = ""
3989:     * StringUtils.chomp("abc \r")      = "abc "
3990:     * StringUtils.chomp("abc\n")       = "abc"
3991:     * StringUtils.chomp("abc\r\n")     = "abc"
3992:     * StringUtils.chomp("abc\r\n\r\n") = "abc\r\n"
3993:     * StringUtils.chomp("abc\n\r")     = "abc\n"
3994:     * StringUtils.chomp("abc\n\rabc")  = "abc\n\rabc"
3995:     * StringUtils.chomp("\r")          = ""
3996:     * StringUtils.chomp("\n")          = ""
3997:     * StringUtils.chomp("\r\n")        = ""
3998:     * </pre>
3999:     *
4000:     * @param str  the String to chomp a newline from, may be null
4001:     * @return String without newline, <code>null</code> if null String input
4002:     */
   /*  public static String chomp(String str) {
	          if (isEmpty(str)) {
            return str;
        }

	          if (str.length() == 1) {
            char ch = str.charAt(0);
	              if (ch == CharUtils.CR || ch == CharUtils.LF) {
                return EMPTY;
            }
            return str;
        }

        int lastIdx = str.length() - 1;
        char last = str.charAt(lastIdx);

	          if (last == CharUtils.LF) {
	              if (str.charAt(lastIdx - 1) == CharUtils.CR) {
                lastIdx--;
            }
        } else if (last != CharUtils.CR) {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }
*/
    /**
4030:     * <p>Removes <code>separator</code> from the end of
4031:     * <code>str</code> if it's there, otherwise leave it alone.</p>
4032:     *
4033:     * <p>NOTE: This method changed in version 2.0.
4034:     * It now more closely matches Perl chomp.
4035:     * For the previous behavior, use {@link #substringBeforeLast(String, String)}.
4036:     * This method uses {@link String#endsWith(String)}.</p>
4037:     *
4038:     * <pre>
4039:     * StringUtils.chomp(null, *)         = null
4040:     * StringUtils.chomp("", *)           = ""
4041:     * StringUtils.chomp("foobar", "bar") = "foo"
4042:     * StringUtils.chomp("foobar", "baz") = "foobar"
4043:     * StringUtils.chomp("foo", "foo")    = ""
4044:     * StringUtils.chomp("foo ", "foo")   = "foo "
4045:     * StringUtils.chomp(" foo", "foo")   = " "
4046:     * StringUtils.chomp("foo", "foooo")  = "foo"
4047:     * StringUtils.chomp("foo", "")       = "foo"
4048:     * StringUtils.chomp("foo", null)     = "foo"
4049:     * </pre>
4050:     *
4051:     * @param str  the String to chomp from, may be null
4052:     * @param separator  separator String, may be null
4053:     * @return String without trailing separator, <code>null</code> if null String input
4054:     */
     public static String chomp(String str, String separator) {
	          if (isEmpty(str) || separator == null) {
            return str;
        }
	          if (str.endsWith(separator)) {
            return str.substring(0, str.length() - separator.length());
        }
        return str;
    }

    /**
4066:     * <p>Remove any &quot;\n&quot; if and only if it is at the end
4067:     * of the supplied String.</p>
4068:     *
4069:     * @param str  the String to chomp from, must not be null
4070:     * @return String without chomped ending
4071:     * @throws NullPointerException if str is <code>null</code>
4072:     * @deprecated Use {@link #chomp(String)} instead.
4073:     *             Method will be removed in Commons Lang 3.0.
4074:     */
   public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    /**
4080:     * <p>Remove a value if and only if the String ends with that value.</p>
4081:     *
4082:     * @param str  the String to chomp from, must not be null
4083:     * @param sep  the String to chomp, must not be null
4084:     * @return String without chomped ending
4085:     * @throws NullPointerException if str or sep is <code>null</code>
4086:     * @deprecated Use {@link #chomp(String,String)} instead.
4087:     *             Method will be removed in Commons Lang 3.0.
4088:     */
     public static String chompLast(String str, String sep) {
	          if (str.length() == 0) {
            return str;
        }
        String sub = str.substring(str.length() - sep.length());
	          if (sep.equals(sub)) {
            return str.substring(0, str.length() - sep.length());
        }
        return str;
    }

    /**
4101:     * <p>Remove everything and return the last value of a supplied String, and
4102:     * everything after it from a String.</p>
4103:     *
4104:     * @param str  the String to chomp from, must not be null
4105:     * @param sep  the String to chomp, must not be null
4106:     * @return String chomped
4107:     * @throws NullPointerException if str or sep is <code>null</code>
4108:     * @deprecated Use {@link #substringAfterLast(String, String)} instead
4109:     *             (although this doesn't include the separator)
4110:     *             Method will be removed in Commons Lang 3.0.
4111:     */
     public static String getChomp(String str, String sep) {
        int idx = str.lastIndexOf(sep);
	          if (idx == str.length() - sep.length()) {
            return sep;
        } else if (idx != -1) {
            return str.substring(idx);
        } else {
            return EMPTY;
        }
    }

    /**
4124:     * <p>Remove the first value of a supplied String, and everything before it
4125:     * from a String.</p>
4126:     *
4127:     * @param str  the String to chomp from, must not be null
4128:     * @param sep  the String to chomp, must not be null
4129:     * @return String without chomped beginning
4130:     * @throws NullPointerException if str or sep is <code>null</code>
4131:     * @deprecated Use {@link #substringAfter(String,String)} instead.
4132:     *             Method will be removed in Commons Lang 3.0.
4133:     */
     public static String prechomp(String str, String sep) {
        int idx = str.indexOf(sep);
	          if (idx == -1) {
            return str;
        }             
        return str.substring(idx + sep.length());
    }

    /**
4143:     * <p>Remove and return everything before the first value of a
4144:     * supplied String from another String.</p>
4145:     *
4146:     * @param str  the String to chomp from, must not be null
4147:     * @param sep  the String to chomp, must not be null
4148:     * @return String prechomped
4149:     * @throws NullPointerException if str or sep is <code>null</code>
4150:     * @deprecated Use {@link #substringBefore(String,String)} instead
4151:     *             (although this doesn't include the separator).
4152:     *             Method will be removed in Commons Lang 3.0.
4153:     */
     public static String getPrechomp(String str, String sep) {
        int idx = str.indexOf(sep);
	          if (idx == -1) {
            return EMPTY;
        } 
        return str.substring(0, idx + sep.length());
    }

    // Chopping
    //-----------------------------------------------------------------------
    /**
4165:     * <p>Remove the last character from a String.</p>
4166:     *
4167:     * <p>If the String ends in <code>\r\n</code>, then remove both
4168:     * of them.</p>
4169:     *
4170:     * <pre>
4171:     * StringUtils.chop(null)          = null
4172:     * StringUtils.chop("")            = ""
4173:     * StringUtils.chop("abc \r")      = "abc "
4174:     * StringUtils.chop("abc\n")       = "abc"
4175:     * StringUtils.chop("abc\r\n")     = "abc"
4176:     * StringUtils.chop("abc")         = "ab"
4177:     * StringUtils.chop("abc\nabc")    = "abc\nab"
4178:     * StringUtils.chop("a")           = ""
4179:     * StringUtils.chop("\r")          = ""
4180:     * StringUtils.chop("\n")          = ""
4181:     * StringUtils.chop("\r\n")        = ""
4182:     * </pre>
4183:     *
4184:     * @param str  the String to chop last character from, may be null
4185:     * @return String without last character, <code>null</code> if null String input
4186:     */
	 /*     public static String chop(String str) {
	          if (str == null) {
            return null;
        }
        int strLen = str.length();
	          if (strLen < 2) {
            return EMPTY;
        }
        int lastIdx = strLen - 1;
        String ret = str.substring(0, lastIdx);
        char last = str.charAt(lastIdx)
                if (last == CharUtils.LF) {
	              if (ret.charAt(lastIdx - 1) == CharUtils.CR) {
                return ret.substring(0, lastIdx - 1);
            }
        }
        return ret;
    }
*/
    /**
4207:     * <p>Removes <code>\n</code> from end of a String if it's there.
4208:     * If a <code>\r</code> precedes it, then remove that too.</p>
4209:     *
4210:     * @param str  the String to chop a newline from, must not be null
4211:     * @return String without newline
4212:     * @throws NullPointerException if str is <code>null</code>
4213:     * @deprecated Use {@link #chomp(String)} instead.
4214:     *             Method will be removed in Commons Lang 3.0.
4215:     */
/*	      public static String chopNewline(String str) {
        int lastIdx = str.length() - 1;
	          if (lastIdx <= 0) {
            return EMPTY;
        }
        char last = str.charAt(lastIdx);
	          if (last == CharUtils.LF) {
	              if (str.charAt(lastIdx - 1) == CharUtils.CR) {
               lastIdx--;
            }
        } else {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }*/

    // Conversion
    //-----------------------------------------------------------------------
    /**
4235:     * <p>Escapes any values it finds into their String form.</p>
4236:     *
4237:     * <p>So a tab becomes the characters <code>'\\'</code> and
4238:     * <code>'t'</code>.</p>
4239:     *
4240:     * <p>As of Lang 2.0, this calls {@link StringEscapeUtils#escapeJava(String)}
4241:     * behind the scenes.
4242:     * </p>
4243:     * @see StringEscapeUtils#escapeJava(java.lang.String)
4244:     * @param str String to escape values in
4245:     * @return String with escaped values
4246:     * @throws NullPointerException if str is <code>null</code>
4247:     * @deprecated Use {@link StringEscapeUtils#escapeJava(String)}
4248:     *             This method will be removed in Commons Lang 3.0
4249:     */
    /*  public static String escape(String str) {
        return StringEscapeUtils.escapeJava(str);
    }
*/
    // Padding
    //-----------------------------------------------------------------------
    /**
4257:     * <p>Repeat a String <code>repeat</code> times to form a
4258:     * new String.</p>
4259:     *
4260:     * <pre>
4261:     * StringUtils.repeat(null, 2) = null
4262:     * StringUtils.repeat("", 0)   = ""
4263:     * StringUtils.repeat("", 2)   = ""
4264:     * StringUtils.repeat("a", 3)  = "aaa"
4265:     * StringUtils.repeat("ab", 2) = "abab"
4266:     * StringUtils.repeat("a", -2) = ""
4267:     * </pre>
4268:     *
4269:     * @param str  the String to repeat, may be null
4270:     * @param repeat  number of times to repeat str, negative treated as zero
4271:     * @return a new String consisting of the original String repeated,
4272:     *  <code>null</code> if null String input
4273:     */
	      public static String repeat(String str, int repeat) {
        // Performance tuned for 2.0 (JDK1.4)

	          if (str == null) {
            return null;
        }
	          if (repeat <= 0) {
            return EMPTY;
        }
        int inputLength = str.length();
	          if (repeat == 1 || inputLength == 0) {
            return str;
        }
	          if (inputLength == 1 && repeat <= PAD_LIMIT) {
            return padding(repeat, str.charAt(0));
        }

        int outputLength = inputLength * repeat;
	          switch (inputLength) {
            case 1 :
                char ch = str.charAt(0);
                char[] output1 = new char[outputLength];
	                  for (int i = repeat - 1; i >= 0; i--) {
                    output1[i] = ch;
                }
               return new String(output1);
            case 2 :
                char ch0 = str.charAt(0);
                char ch1 = str.charAt(1);
                char[] output2 = new char[outputLength];
	                  for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }
                return new String(output2);
            default :
                StringBuffer buf = new StringBuffer(outputLength);
	                  for (int i = 0; i < repeat; i++) {
                    buf.append(str);
                }
                return buf.toString();
        }
    }

    /**
4319:     * <p>Returns padding using the specified delimiter repeated
4320:     * to a given length.</p>
4321:     *
4322:     * <pre>
4323:     * StringUtils.padding(0, 'e')  = ""
4324:     * StringUtils.padding(3, 'e')  = "eee"
4325:     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
4326:     * </pre>
4327:     *
4328:     * <p>Note: this method doesn't not support padding with
4329:     * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode Supplementary Characters</a>
4330:     * as they require a pair of <code>char</code>s to be represented.
4331:     * If you are needing to support full I18N of your applications
4332:     * consider using {@link #repeat(String, int)} instead. 
4333:     * </p>
4334:     *
4335:     * @param repeat  number of times to repeat delim
4336:     * @param padChar  character to repeat
4337:     * @return String with repeated character
4338:     * @throws IndexOutOfBoundsException if <code>repeat &lt; 0</code>
4339:     * @see #repeat(String, int)
4340:     */
      private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
	          if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
	          for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }

    /**
4353:     * <p>Right pad a String with spaces (' ').</p>
4354:     *
4355:     * <p>The String is padded to the size of <code>size</code>.</p>
4356:     *
4357:     * <pre>
4358:     * StringUtils.rightPad(null, *)   = null
4359:     * StringUtils.rightPad("", 3)     = "   "
4360:     * StringUtils.rightPad("bat", 3)  = "bat"
4361:     * StringUtils.rightPad("bat", 5)  = "bat  "
4362:     * StringUtils.rightPad("bat", 1)  = "bat"
4363:     * StringUtils.rightPad("bat", -1) = "bat"
4364:     * </pre>
4365:     *
4366:     * @param str  the String to pad out, may be null
4367:     * @param size  the size to pad to
4368:     * @return right padded String or original String if no padding is necessary,
4369:     *  <code>null</code> if null String input
4370:     */
     public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    /**
4376:     * <p>Right pad a String with a specified character.</p>
4377:     *
4378:     * <p>The String is padded to the size of <code>size</code>.</p>
4379:     *
4380:     * <pre>
4381:     * StringUtils.rightPad(null, *, *)     = null
4382:     * StringUtils.rightPad("", 3, 'z')     = "zzz"
4383:     * StringUtils.rightPad("bat", 3, 'z')  = "bat"
4384:     * StringUtils.rightPad("bat", 5, 'z')  = "batzz"
4385:     * StringUtils.rightPad("bat", 1, 'z')  = "bat"
4386:     * StringUtils.rightPad("bat", -1, 'z') = "bat"
4387:     * </pre>
4388:     *
4389:     * @param str  the String to pad out, may be null
4390:     * @param size  the size to pad to
4391:     * @param padChar  the character to pad with
4392:     * @return right padded String or original String if no padding is necessary,
4393:     *  <code>null</code> if null String input
4394:     * @since 2.0
4395:     */
     public static String rightPad(String str, int size, char padChar) {
	          if (str == null) {
            return null;
        }
        int pads = size - str.length();
	          if (pads <= 0) {
            return str; // returns original String when possible
        }
	          if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
4411:     * <p>Right pad a String with a specified String.</p>
4412:     *
4413:     * <p>The String is padded to the size of <code>size</code>.</p>
4414:     *
4415:     * <pre>
4416:     * StringUtils.rightPad(null, *, *)      = null
4417:     * StringUtils.rightPad("", 3, "z")      = "zzz"
4418:     * StringUtils.rightPad("bat", 3, "yz")  = "bat"
4419:     * StringUtils.rightPad("bat", 5, "yz")  = "batyz"
4420:     * StringUtils.rightPad("bat", 8, "yz")  = "batyzyzy"
4421:     * StringUtils.rightPad("bat", 1, "yz")  = "bat"
4422:     * StringUtils.rightPad("bat", -1, "yz") = "bat"
4423:     * StringUtils.rightPad("bat", 5, null)  = "bat  "
4424:     * StringUtils.rightPad("bat", 5, "")    = "bat  "
4425:     * </pre>
4426:     *
4427:     * @param str  the String to pad out, may be null
4428:     * @param size  the size to pad to
4429:     * @param padStr  the String to pad with, null or empty treated as single space
4430:     * @return right padded String or original String if no padding is necessary,
4431:     *  <code>null</code> if null String input
4432:     */
     public static String rightPad(String str, int size, String padStr) {
	          if (str == null) {
            return null;
        }
	          if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
	          if (pads <= 0) {
            return str; // returns original String when possible
        }
	          if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

	          if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
	              for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
4465:     * <p>Left pad a String with spaces (' ').</p>
4466:     *
4467:     * <p>The String is padded to the size of <code>size<code>.</p>
4468:     *
4469:     * <pre>
4470:     * StringUtils.leftPad(null, *)   = null
4471:     * StringUtils.leftPad("", 3)     = "   "
4472:     * StringUtils.leftPad("bat", 3)  = "bat"
4473:     * StringUtils.leftPad("bat", 5)  = "  bat"
4474:     * StringUtils.leftPad("bat", 1)  = "bat"
4475:     * StringUtils.leftPad("bat", -1) = "bat"
4476:     * </pre>
4477:     *
4478:     * @param str  the String to pad out, may be null
4479:     * @param size  the size to pad to
4480:     * @return left padded String or original String if no padding is necessary,
4481:     *  <code>null</code> if null String input
4482:     */
     public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    /**
4488:     * <p>Left pad a String with a specified character.</p>
4489:     *
4490:     * <p>Pad to a size of <code>size</code>.</p>
4491:     *
4492:     * <pre>
4493:     * StringUtils.leftPad(null, *, *)     = null
4494:     * StringUtils.leftPad("", 3, 'z')     = "zzz"
4495:     * StringUtils.leftPad("bat", 3, 'z')  = "bat"
4496:     * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
4497:     * StringUtils.leftPad("bat", 1, 'z')  = "bat"
4498:     * StringUtils.leftPad("bat", -1, 'z') = "bat"
4499:     * </pre>
4500:     *
4501:     * @param str  the String to pad out, may be null
4502:     * @param size  the size to pad to
4503:     * @param padChar  the character to pad with
4504:     * @return left padded String or original String if no padding is necessary,
4505:     *  <code>null</code> if null String input
4506:     * @since 2.0
4507:     */
     public static String leftPad(String str, int size, char padChar) {
	          if (str == null) {
            return null;
        }
        int pads = size - str.length();
	          if (pads <= 0) {
            return str; // returns original String when possible
       }
	          if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }
    /**
4523:     * <p>Left pad a String with a specified String.</p>
4524:     *
4525:     * <p>Pad to a size of <code>size</code>.</p>
4526:     *
4527:     * <pre>
4528:     * StringUtils.leftPad(null, *, *)      = null
4529:     * StringUtils.leftPad("", 3, "z")      = "zzz"
4530:     * StringUtils.leftPad("bat", 3, "yz")  = "bat"
4531:     * StringUtils.leftPad("bat", 5, "yz")  = "yzbat"
4532:     * StringUtils.leftPad("bat", 8, "yz")  = "yzyzybat"
4533:     * StringUtils.leftPad("bat", 1, "yz")  = "bat"
4534:     * StringUtils.leftPad("bat", -1, "yz") = "bat"
4535:     * StringUtils.leftPad("bat", 5, null)  = "  bat"
4536:     * StringUtils.leftPad("bat", 5, "")    = "  bat"
4537:     * </pre>
4538:     *
4539:     * @param str  the String to pad out, may be null
4540:     * @param size  the size to pad to
4541:     * @param padStr  the String to pad with, null or empty treated as single space
4542:     * @return left padded String or original String if no padding is necessary,
4543:     *  <code>null</code> if null String input
4544:     */
     public static String leftPad(String str, int size, String padStr) {
	          if (str == null) {
            return null;
        }
	          if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
	          if (pads <= 0) {
            return str; // returns original String when possible
        }
	          if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

	          if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
	              for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
4577:     * Gets a String's length or <code>0</code> if the String is <code>null</code>.
4578:     * 
4579:     * @param str
4580:     *            a String or <code>null</code>
4581:     * @return String length or <code>0</code> if the String is <code>null</code>.
4582:     * @since 2.4
4583:     */
	      public static int length(String str) {
        return str == null ? 0 : str.length();
    }
    
    // Centering
    //-----------------------------------------------------------------------
    /**
4591:     * <p>Centers a String in a larger String of size <code>size</code>
4592:     * using the space character (' ').<p>
4593:     *
4594:     * <p>If the size is less than the String length, the String is returned.
4595:     * A <code>null</code> String returns <code>null</code>.
4596:     * A negative size is treated as zero.</p>
4597:     *
4598:     * <p>Equivalent to <code>center(str, size, " ")</code>.</p>
4599:     *
4600:     * <pre>
4601:     * StringUtils.center(null, *)   = null
4602:     * StringUtils.center("", 4)     = "    "
4603:     * StringUtils.center("ab", -1)  = "ab"
4604:     * StringUtils.center("ab", 4)   = " ab "
4605:     * StringUtils.center("abcd", 2) = "abcd"
4606:     * StringUtils.center("a", 4)    = " a  "
4607:     * </pre>
4608:     *
4609:     * @param str  the String to center, may be null
4610:     * @param size  the int size of new String, negative treated as zero
4611:     * @return centered String, <code>null</code> if null String input
4612:     */
    public static String center(String str, int size) {
        return center(str, size, ' ');
    }
    /**
4618:     * <p>Centers a String in a larger String of size <code>size</code>.
4619:     * Uses a supplied character as the value to pad the String with.</p>
4620:     *
4621:     * <p>If the size is less than the String length, the String is returned.
4622:     * A <code>null</code> String returns <code>null</code>.
4623:     * A negative size is treated as zero.</p>
4624:     *
4625:     * <pre>
4626:     * StringUtils.center(null, *, *)     = null
4627:     * StringUtils.center("", 4, ' ')     = "    "
4628:     * StringUtils.center("ab", -1, ' ')  = "ab"
4629:     * StringUtils.center("ab", 4, ' ')   = " ab"
4630:     * StringUtils.center("abcd", 2, ' ') = "abcd"
4631:     * StringUtils.center("a", 4, ' ')    = " a  "
4632:     * StringUtils.center("a", 4, 'y')    = "yayy"
4633:     * </pre>
4634:     *
4635:     * @param str  the String to center, may be null
4636:     * @param size  the int size of new String, negative treated as zero
4637:     * @param padChar  the character to pad the new String with
4638:     * @return centered String, <code>null</code> if null String input
4639:     * @since 2.0
4640:     */
  public static String center(String str, int size, char padChar) {
	          if (str == null || size <= 0) {
            return str;
        }
        int strLen = str.length();
        int pads = size - strLen;
	          if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, padChar);
        return str;
    }

    /**
4656:     * <p>Centers a String in a larger String of size <code>size</code>.
4657:     * Uses a supplied String as the value to pad the String with.</p>
4658:     *
4659:     * <p>If the size is less than the String length, the String is returned.
4660:     * A <code>null</code> String returns <code>null</code>.
4661:     * A negative size is treated as zero.</p>
4662:     *
4663:     * <pre>
4664:     * StringUtils.center(null, *, *)     = null
4665:     * StringUtils.center("", 4, " ")     = "    "
4666:     * StringUtils.center("ab", -1, " ")  = "ab"
4667:     * StringUtils.center("ab", 4, " ")   = " ab"
4668:     * StringUtils.center("abcd", 2, " ") = "abcd"
4669:     * StringUtils.center("a", 4, " ")    = " a  "
4670:     * StringUtils.center("a", 4, "yz")   = "yayz"
4671:     * StringUtils.center("abc", 7, null) = "  abc  "
4672:     * StringUtils.center("abc", 7, "")   = "  abc  "
4673:     * </pre>
4674:     *
4675:     * @param str  the String to center, may be null
4676:     * @param size  the int size of new String, negative treated as zero
4677:     * @param padStr  the String to pad the new String with, must not be null or empty
4678:     * @return centered String, <code>null</code> if null String input
4679:     * @throws IllegalArgumentException if padStr is <code>null</code> or empty
4680:     */
 public static String center(String str, int size, String padStr) {
	          if (str == null || size <= 0) {
            return str;
        }
	          if (isEmpty(padStr)) {
            padStr = " ";
        }
        int strLen = str.length();
        int pads = size - strLen;
	          if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padStr);
        str = rightPad(str, size, padStr);
        return str;
    }

    // Case conversion
    //-----------------------------------------------------------------------
    /**
4701:     * <p>Converts a String to upper case as per {@link String#toUpperCase()}.</p>
4702:     *
4703:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
4704:     *
4705:     * <pre>
4706:     * StringUtils.upperCase(null)  = null
4707:     * StringUtils.upperCase("")    = ""
4708:     * StringUtils.upperCase("aBc") = "ABC"
4709:     * </pre>
4710:     *
4711:     * @param str  the String to upper case, may be null
4712:     * @return the upper cased String, <code>null</code> if null String input
4713:     */
  public static String upperCase(String str) {
	          if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
4722:     * <p>Converts a String to lower case as per {@link String#toLowerCase()}.</p>
4723:     *
4724:     * <p>A <code>null</code> input String returns <code>null</code>.</p>
4725:     *
4726:     * <pre>
4727:     * StringUtils.lowerCase(null)  = null
4728:     * StringUtils.lowerCase("")    = ""
4729:     * StringUtils.lowerCase("aBc") = "abc"
4730:     * </pre>
4731:     *
4732:     * @param str  the String to lower case, may be null
4733:     * @return the lower cased String, <code>null</code> if null String input
4734:     */
    public static String lowerCase(String str) {
	          if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    /**
4743:     * <p>Capitalizes a String changing the first letter to title case as
4744:     * per {@link Character#toTitleCase(char)}. No other letters are changed.</p>
4745:     *
4746:     * <p>For a word based algorithm, see {@link WordUtils#capitalize(String)}.
4747:     * A <code>null</code> input String returns <code>null</code>.</p>
4748:     *
4749:     * <pre>
4750:     * StringUtils.capitalize(null)  = null
4751:     * StringUtils.capitalize("")    = ""
4752:     * StringUtils.capitalize("cat") = "Cat"
4753:     * StringUtils.capitalize("cAt") = "CAt"
4754:     * </pre>
4755:     *
4756:     * @param str  the String to capitalize, may be null
4757:     * @return the capitalized String, <code>null</code> if null String input
4758:     * @see WordUtils#capitalize(String)
4759:     * @see #uncapitalize(String)
4760:     * @since 2.0
4761:     */
    public static String capitalize(String str) {
        int strLen;
	          if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
            .append(Character.toTitleCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
    }
    /**
4774:     * <p>Capitalizes a String changing the first letter to title case as
4775:     * per {@link Character#toTitleCase(char)}. No other letters are changed.</p>
4776:     *
4777:     * @param str  the String to capitalize, may be null
4778:     * @return the capitalized String, <code>null</code> if null String input
4779:     * @deprecated Use the standardly named {@link #capitalize(String)}.
4780:     *             Method will be removed in Commons Lang 3.0.
4781:     */
     public static String capitalise(String str) {
        return capitalize(str);
    }

    /**
4787:     * <p>Uncapitalizes a String changing the first letter to title case as
4788:     * per {@link Character#toLowerCase(char)}. No other letters are changed.</p>
4789:     *
4790:     * <p>For a word based algorithm, see {@link WordUtils#uncapitalize(String)}.
4791:     * A <code>null</code> input String returns <code>null</code>.</p>
4792:     *
4793:     * <pre>
4794:     * StringUtils.uncapitalize(null)  = null
4795:     * StringUtils.uncapitalize("")    = ""
4796:     * StringUtils.uncapitalize("Cat") = "cat"
4797:     * StringUtils.uncapitalize("CAT") = "cAT"
4798:     * </pre>
4799:     *
4800:     * @param str  the String to uncapitalize, may be null
4801:     * @return the uncapitalized String, <code>null</code> if null String input
4802:     * @see WordUtils#uncapitalize(String)
4803:     * @see #capitalize(String)
4804:     * @since 2.0
4805:     */
    public static String uncapitalize(String str) {
        int strLen;
	          if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
            .append(Character.toLowerCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
    }

    /**
4818:     * <p>Uncapitalizes a String changing the first letter to title case as
4819:     * per {@link Character#toLowerCase(char)}. No other letters are changed.</p>
4820:     *
4821:     * @param str  the String to uncapitalize, may be null
4822:     * @return the uncapitalized String, <code>null</code> if null String input
4823:     * @deprecated Use the standardly named {@link #uncapitalize(String)}.
4824:     *             Method will be removed in Commons Lang 3.0.
4825:     */
    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }

    /**
4831:     * <p>Swaps the case of a String changing upper and title case to
4832:     * lower case, and lower case to upper case.</p>
4833:     *
4834:     * <ul>
4835:     *  <li>Upper case character converts to Lower case</li>
4836:     *  <li>Title case character converts to Lower case</li>
4837:     *  <li>Lower case character converts to Upper case</li>
4838:     * </ul>
4839:     *
4840:     * <p>For a word based algorithm, see {@link WordUtils#swapCase(String)}.
4841:     * A <code>null</code> input String returns <code>null</code>.</p>
4842:     *
4843:     * <pre>
4844:     * StringUtils.swapCase(null)                 = null
4845:     * StringUtils.swapCase("")                   = ""
4846:     * StringUtils.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
4847:     * </pre>
4848:     *
4849:     * <p>NOTE: This method changed in Lang version 2.0.
4850:     * It no longer performs a word based algorithm.
4851:     * If you only use ASCII, you will notice no change.
4852:     * That functionality is available in WordUtils.</p>
4853:     *
4854:     * @param str  the String to swap case, may be null
4855:     * @return the changed String, <code>null</code> if null String input
4856:     */
    public static String swapCase(String str) {
        int strLen;
	          if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        StringBuffer buffer = new StringBuffer(strLen);

        char ch = 0;
	          for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);
	              if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }
            buffer.append(ch);
        }
        return buffer.toString();
    }

    /**
4880:     * <p>Capitalizes all the whitespace separated words in a String.
4881:     * Only the first letter of each word is changed.</p>
4882:     *
4883:     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
4884:     * A <code>null</code> input String returns <code>null</code>.</p>
4885:     *
4886:     * @param str  the String to capitalize, may be null
4887:     * @return capitalized String, <code>null</code> if null String input
4888:     * @deprecated Use the relocated {@link WordUtils#capitalize(String)}.
4889:     *             Method will be removed in Commons Lang 3.0.
4890:     */
    /* public static String capitaliseAllWords(String str) {
        return WordUtils.capitalize(str);
    }
*/
    // Count matches
    //-----------------------------------------------------------------------
    /**

4899:     *
4900:     * <p>A <code>null</code> or empty ("") String input returns <code>0</code>.</p>
4901:     *
4902:     * <pre>
4903:     * StringUtils.countMatches(null, *)       = 0
4904:     * StringUtils.countMatches("", *)         = 0
4905:     * StringUtils.countMatches("abba", null)  = 0
4906:     * StringUtils.countMatches("abba", "")    = 0
4907:     * StringUtils.countMatches("abba", "a")   = 2
4908:     * StringUtils.countMatches("abba", "ab")  = 1
4909:     * StringUtils.countMatches("abba", "xxx") = 0
4910:     * </pre>
4911:     *
4912:     * @param str  the String to check, may be null
4913:     * @param sub  the substring to count, may be null
4914:     * @return the number of occurrences, 0 if either String is <code>null</code>
4915:     */
     public static int countMatches(String str, String sub) {
	          if (isEmpty(str) || isEmpty(sub)) {
            return 0;
        }
        int count = 0;
        int idx = 0;
	          while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    // Character Tests
    //-----------------------------------------------------------------------
    /**
4932:     * <p>Checks if the String contains only unicode letters.</p>
4933:     *
4934:     * <p><code>null</code> will return <code>false</code>.
4935:     * An empty String ("") will return <code>true</code>.</p>
4936:     *
4937:     * <pre>
4938:     * StringUtils.isAlpha(null)   = false
4939:     * StringUtils.isAlpha("")     = true
4940:     * StringUtils.isAlpha("  ")   = false
4941:     * StringUtils.isAlpha("abc")  = true
4942:     * StringUtils.isAlpha("ab2c") = false
4943:     * StringUtils.isAlpha("ab-c") = false
4944:     * </pre>
4945:     *
4946:     * @param str  the String to check, may be null
4947:     * @return <code>true</code> if only contains letters, and is non-null
4948:     */
     public static boolean isAlpha(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if (Character.isLetter(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
4963:     * <p>Checks if the String contains only unicode letters and
4964:     * space (' ').</p>
4965:     *
4966:     * <p><code>null</code> will return <code>false</code>
4967:     * An empty String ("") will return <code>true</code>.</p>
4968:     *
4969:     * <pre>
4970:     * StringUtils.isAlphaSpace(null)   = false
4971:     * StringUtils.isAlphaSpace("")     = true
4972:     * StringUtils.isAlphaSpace("  ")   = true
4973:     * StringUtils.isAlphaSpace("abc")  = true
4974:     * StringUtils.isAlphaSpace("ab c") = true
4975:     * StringUtils.isAlphaSpace("ab2c") = false
4976:     * StringUtils.isAlphaSpace("ab-c") = false
4977:     * </pre>
4978:     *
4979:     * @param str  the String to check, may be null
4980:     * @return <code>true</code> if only contains letters and space,
4981:     *  and is non-null
4982:     */
    public static boolean isAlphaSpace(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
4997:     * <p>Checks if the String contains only unicode letters or digits.</p>
4998:     *
4999:     * <p><code>null</code> will return <code>false</code>.
5000:     * An empty String ("") will return <code>true</code>.</p>
5001:     *
5002:     * <pre>
5003:     * StringUtils.isAlphanumeric(null)   = false
5004:     * StringUtils.isAlphanumeric("")     = true
5005:     * StringUtils.isAlphanumeric("  ")   = false
5006:     * StringUtils.isAlphanumeric("abc")  = true
5007:     * StringUtils.isAlphanumeric("ab c") = false
5008:     * StringUtils.isAlphanumeric("ab2c") = true
5009:     * StringUtils.isAlphanumeric("ab-c") = false
5010:     * </pre>
5011:     *
5012:     * @param str  the String to check, may be null
5013:     * @return <code>true</code> if only contains letters or digits,
5014:     *  and is non-null
5015:     */
  public static boolean isAlphanumeric(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if (Character.isLetterOrDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
5030:     * <p>Checks if the String contains only unicode letters, digits
5031:     * or space (<code>' '</code>).</p>
5032:     *
5033:     * <p><code>null</code> will return <code>false</code>.
5034:     * An empty String ("") will return <code>true</code>.</p>
5035:     *
5036:     * <pre>
5037:     * StringUtils.isAlphanumeric(null)   = false
5038:     * StringUtils.isAlphanumeric("")     = true
5039:     * StringUtils.isAlphanumeric("  ")   = true
5040:     * StringUtils.isAlphanumeric("abc")  = true
5041:     * StringUtils.isAlphanumeric("ab c") = true
5042:     * StringUtils.isAlphanumeric("ab2c") = true
5043:     * StringUtils.isAlphanumeric("ab-c") = false
5044:     * </pre>
5045:     *
5046:     * @param str  the String to check, may be null
5047:     * @return <code>true</code> if only contains letters, digits or space,
5048:     *  and is non-null
5049:     */
 public static boolean isAlphanumericSpace(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if ((Character.isLetterOrDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
5064:     * <p>Checks if the string contains only ASCII printable characters.</p>
5065:     * 
5066:     * <p><code>null</code> will return <code>false</code>.
5067:     * An empty String ("") will return <code>true</code>.</p>
5068:     * 
5069:     * <pre>
5070:     * StringUtils.isAsciiPrintable(null)     = false
5071:     * StringUtils.isAsciiPrintable("")       = true
5072:     * StringUtils.isAsciiPrintable(" ")      = true
5073:     * StringUtils.isAsciiPrintable("Ceki")   = true
5074:     * StringUtils.isAsciiPrintable("ab2c")   = true
5075:     * StringUtils.isAsciiPrintable("!ab-c~") = true
5076:     * StringUtils.isAsciiPrintable("\u0020") = true
5077:     * StringUtils.isAsciiPrintable("\u0021") = true
5078:     * StringUtils.isAsciiPrintable("\u007e") = true
5079:     * StringUtils.isAsciiPrintable("\u007f") = false
5080:     * StringUtils.isAsciiPrintable("Ceki G\u00fclc\u00fc") = false
5081:     * </pre>
5082:     *
5083:     * @param str the string to check, may be null
5084:     * @return <code>true</code> if every character is in the range
5085:     *  32 thru 126
5086:     * @since 2.1
5087:     */
    /*  public static boolean isAsciiPrintable(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if (CharUtils.isAsciiPrintable(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }*/

    /**

5103:     * A decimal point is not a unicode digit and returns false.</p>
5104:     *
5105:     * <p><code>null</code> will return <code>false</code>.
5106:     * An empty String ("") will return <code>true</code>.</p>
5107:     *
5108:     * <pre>
5109:     * StringUtils.isNumeric(null)   = false
5110:     * StringUtils.isNumeric("")     = true
5111:     * StringUtils.isNumeric("  ")   = false
5112:     * StringUtils.isNumeric("123")  = true
5113:     * StringUtils.isNumeric("12 3") = false
5114:     * StringUtils.isNumeric("ab2c") = false
5115:     * StringUtils.isNumeric("12-3") = false
5116:     * StringUtils.isNumeric("12.3") = false
5117:     * </pre>
5118:     *
5119:     * @param str  the String to check, may be null
5120:     * @return <code>true</code> if only contains digits, and is non-null
5121:     */
     public static boolean isNumeric(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
5136:     * <p>Checks if the String contains only unicode digits or space
5137:     * (<code>' '</code>).
5138:     * A decimal point is not a unicode digit and returns false.</p>
5139:     *
5140:     * <p><code>null</code> will return <code>false</code>.
5141:     * An empty String ("") will return <code>true</code>.</p>
5142:     *
5143:     * <pre>
5144:     * StringUtils.isNumeric(null)   = false
5145:     * StringUtils.isNumeric("")     = true
5146:     * StringUtils.isNumeric("  ")   = true
5147:     * StringUtils.isNumeric("123")  = true
5148:     * StringUtils.isNumeric("12 3") = true
5149:     * StringUtils.isNumeric("ab2c") = false
5150:     * StringUtils.isNumeric("12-3") = false
5151:     * StringUtils.isNumeric("12.3") = false
5152:     * </pre>
5153:     *
5154:    * @param str  the String to check, may be null
5155:     * @return <code>true</code> if only contains digits or space,
5156:     *  and is non-null
5157:     */
     public static boolean isNumericSpace(String str) {
	          if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if ((Character.isDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
5172:     * <p>Checks if the String contains only whitespace.</p>
5173:     *
5174:     * <p><code>null</code> will return <code>false</code>.
5175:     * An empty String ("") will return <code>true</code>.</p>
5176:     *
5177:     * <pre>
5178:     * StringUtils.isWhitespace(null)   = false
5179:     * StringUtils.isWhitespace("")     = true
5180:     * StringUtils.isWhitespace("  ")   = true
5181:     * StringUtils.isWhitespace("abc")  = false
5182:     * StringUtils.isWhitespace("ab2c") = false
5183:     * StringUtils.isWhitespace("ab-c") = false
5184:     * </pre>
5185:     *
5186:     * @param str  the String to check, may be null
5187:     * @return <code>true</code> if only contains whitespace, and is non-null
5188:     * @since 2.0
5189:     */
     public static boolean isWhitespace(String str) {
	if (str == null) {
            return false;
        }
        int sz = str.length();
	          for (int i = 0; i < sz; i++) {
	              if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
       }
        return true;
    }

    // Defaults
    //-----------------------------------------------------------------------
   /**
5206:     * <p>Returns either the passed in String,
5207:     * or if the String is <code>null</code>, an empty String ("").</p>
5208:     *
5209:     * <pre>
5210:     * StringUtils.defaultString(null)  = ""
5211:     * StringUtils.defaultString("")    = ""
5212:     * StringUtils.defaultString("bat") = "bat"
5213:     * </pre>
5214:     *
5215:     * @see ObjectUtils#toString(Object)
5216:     * @see String#valueOf(Object)
5217:     * @param str  the String to check, may be null
5218:     * @return the passed in String, or the empty String if it
5219:     *  was <code>null</code>
5220:     */ 
     public static String defaultString(String str) {
        return str == null ? EMPTY : str;
    }

    /**
5226:     * <p>Returns either the passed in String, or if the String is
5227:     * <code>null</code>, the value of <code>defaultStr</code>.</p>
5228:     *
5229:     * <pre>
5230:     * StringUtils.defaultString(null, "NULL")  = "NULL"
5231:     * StringUtils.defaultString("", "NULL")    = ""
5232:     * StringUtils.defaultString("bat", "NULL") = "bat"
5233:     * </pre>
5234:     *
5235:     * @see ObjectUtils#toString(Object,String)
5236:     * @see String#valueOf(Object)
5237:     * @param str  the String to check, may be null
5238:     * @param defaultStr  the default String to return
5239:     *  if the input is <code>null</code>, may be null
5240:     * @return the passed in String, or the default if it was <code>null</code>
5241:     */
    public static String defaultString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }

    /**
5247:     * <p>Returns either the passed in String, or if the String is
5248:     * empty or <code>null</code>, the value of <code>defaultStr</code>.</p>
5249:     *
5250:     * <pre>
5251:     * StringUtils.defaultIfEmpty(null, "NULL")  = "NULL"
5252:     * StringUtils.defaultIfEmpty("", "NULL")    = "NULL"
5253:     * StringUtils.defaultIfEmpty("bat", "NULL") = "bat"
5254:     * </pre>
5255:     *
5256:     * @see StringUtils#defaultString(String, String)
5257:     * @param str  the String to check, may be null
5258:     * @param defaultStr  the default String to return
5259:     *  if the input is empty ("") or <code>null</code>, may be null
5260:     * @return the passed in String, or the default
5261:     */
     public static String defaultIfEmpty(String str, String defaultStr) {
        return clsUtilidades.isEmpty(str) ? defaultStr : str;
    }

    // Reversing
       /**
5270:     *
5271:     * <p>A <code>null</code> String returns <code>null</code>.</p>
5272:     *
5273:     * <pre>
5274:     * StringUtils.reverse(null)  = null
5275:     * StringUtils.reverse("")    = ""
5276:     * StringUtils.reverse("bat") = "tab"
5277:     * </pre>
5278:     *
5279:     * @param str  the String to reverse, may be null
5280:     * @return the reversed String, <code>null</code> if null String input
5281:     */
     public static String reverse(String str) {
	          if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
5290:     * <p>Reverses a String that is delimited by a specific character.</p>
5291:     *
5292:     * <p>The Strings between the delimiters are not reversed.
5293:     * Thus java.lang.String becomes String.lang.java (if the delimiter
5294:     * is <code>'.'</code>).</p>
5295:     *
5296:     * <pre>
5297:     * StringUtils.reverseDelimited(null, *)      = null
5298:     * StringUtils.reverseDelimited("", *)        = ""
5299:     * StringUtils.reverseDelimited("a.b.c", 'x') = "a.b.c"
5300:     * StringUtils.reverseDelimited("a.b.c", ".") = "c.b.a"
5301:     * </pre>
5302:     *
5303:     * @param str  the String to reverse, may be null
5304:     * @param separatorChar  the separator character to use
5305:     * @return the reversed String, <code>null</code> if null String input
5306:     * @since 2.0
5307:     */
  /*  public static String reverseDelimited(String str, char separatorChar) {
	          if (str == null) {
            return null;
        }
        /// could implement manually, but simple way is to reuse other,
        // probably slower, methods.
        String[] strs = split(str, separatorChar);
        ArrayUtils.reverse(strs);
        return join(strs, separatorChar);
    }
*/
   /**

5321:     *
5322:     * <p>The Strings between the delimiters are not reversed.
5323:     * Thus java.lang.String becomes String.lang.java (if the delimiter
5324:     * is <code>"."</code>).</p>
5325:     *
5326:     * <pre>
5327:     * StringUtils.reverseDelimitedString(null, *)       = null
5328:     * StringUtils.reverseDelimitedString("",*)          = ""
5329:     * StringUtils.reverseDelimitedString("a.b.c", null) = "a.b.c"
5330:     * StringUtils.reverseDelimitedString("a.b.c", ".")  = "c.b.a"
5331:     * </pre>
5332:     *
5333:     * @param str  the String to reverse, may be null
5334:     * @param separatorChars  the separator characters to use, null treated as whitespace
5335:     * @return the reversed String, <code>null</code> if null String input
5336:     * @deprecated Use {@link #reverseDelimited(String, char)} instead.
5337:     *      This method is broken as the join doesn't know which char to use.
5338:     *      Method will be removed in Commons Lang 3.0.
5339:     *
5340:     */
   /*  public static String reverseDelimitedString(String str, String separatorChars) {
	 if (str == null) {
            return null;
        }
        // could implement manually, but simple way is to reuse other,
        // probably slower, methods.
        String[] strs = split(str, separatorChars);
        ArrayUtils.reverse(strs);
	          if (separatorChars == null) {
            return join(strs, ' ');
        }
        return join(strs, separatorChars);
    }
*/
/**
5358:     * <p>Abbreviates a String using ellipses. This will turn
5359:     * "Now is the time for all good men" into "Now is the time for..."</p>
5360:     *
5361:     * <p>Specifically:
5362:     * <ul>
5363:     *   <li>If <code>str</code> is less than <code>maxWidth</code> characters
5364:     *       long, return it.</li>
5365:     *   <li>Else abbreviate it to <code>(substring(str, 0, max-3) + "...")</code>.</li>
5366:     *   <li>If <code>maxWidth</code> is less than <code>4</code>, throw an
5367:     *       <code>IllegalArgumentException</code>.</li>
5368:     *   <li>In no case will it return a String of length greater than
5369:     *       <code>maxWidth</code>.</li>
5370:     * </ul>
5371:     * </p>
5372:     *
5373:     * <pre>
5374:     * StringUtils.abbreviate(null, *)      = null
5375:     * StringUtils.abbreviate("", 4)        = ""
5376:     * StringUtils.abbreviate("abcdefg", 6) = "abc..."
5377:     * StringUtils.abbreviate("abcdefg", 7) = "abcdefg"
5378:     * StringUtils.abbreviate("abcdefg", 8) = "abcdefg"
5379:     * StringUtils.abbreviate("abcdefg", 4) = "a..."
5380:     * StringUtils.abbreviate("abcdefg", 3) = IllegalArgumentException
5381:     * </pre>
5382:     *
5383:     * @param str  the String to check, may be null
5384:     * @param maxWidth  maximum length of result String, must be at least 4
5385:     * @return abbreviated String, <code>null</code> if null String input
5386:     * @throws IllegalArgumentException if the width is too small
5387:     * @since 2.0
5388:     */
     public static String abbreviate(String str, int maxWidth) {
        return abbreviate(str, 0, maxWidth);
    }

    /**
5394:     * <p>Abbreviates a String using ellipses. This will turn
5395:     * "Now is the time for all good men" into "...is the time for..."</p>
5396:     *
5397:     * <p>Works like <code>abbreviate(String, int)</code>, but allows you to specify
5398:     * a "left edge" offset.  Note that this left edge is not necessarily going to
5399:     * be the leftmost character in the result, or the first character following the
5400:     * ellipses, but it will appear somewhere in the result.
5401:     *
5402:     * <p>In no case will it return a String of length greater than
5403:     * <code>maxWidth</code>.</p>
5404:     *
5405:     * <pre>
5406:     * StringUtils.abbreviate(null, *, *)                = null
5407:     * StringUtils.abbreviate("", 0, 4)                  = ""
5408:     * StringUtils.abbreviate("abcdefghijklmno", -1, 10) = "abcdefg..."
5409:     * StringUtils.abbreviate("abcdefghijklmno", 0, 10)  = "abcdefg..."
5410:     * StringUtils.abbreviate("abcdefghijklmno", 1, 10)  = "abcdefg..."
5411:     * StringUtils.abbreviate("abcdefghijklmno", 4, 10)  = "abcdefg..."
5412:     * StringUtils.abbreviate("abcdefghijklmno", 5, 10)  = "...fghi..."
5413:     * StringUtils.abbreviate("abcdefghijklmno", 6, 10)  = "...ghij..."
5414:     * StringUtils.abbreviate("abcdefghijklmno", 8, 10)  = "...ijklmno"
5415:     * StringUtils.abbreviate("abcdefghijklmno", 10, 10) = "...ijklmno"
5416:     * StringUtils.abbreviate("abcdefghijklmno", 12, 10) = "...ijklmno"
5417:     * StringUtils.abbreviate("abcdefghij", 0, 3)        = IllegalArgumentException
5418:     * StringUtils.abbreviate("abcdefghij", 5, 6)        = IllegalArgumentException
5419:     * </pre>
5420:     *
5421:     * @param str  the String to check, may be null
5422:     * @param offset  left edge of source String
5423:     * @param maxWidth  maximum length of result String, must be at least 4
5424:     * @return abbreviated String, <code>null</code> if null String input
5425:     * @throws IllegalArgumentException if the width is too small
5426:     * @since 2.0
5427:     */
    public static String abbreviate(String str, int offset, int maxWidth) {
	          if (str == null) {
            return null;
        }
	          if (maxWidth < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        }
	          if (str.length() <= maxWidth) {
            return str;
        }
	          if (offset > str.length()) {
            offset = str.length();
        }
	          if ((str.length() - offset) < (maxWidth - 3)) {
            offset = str.length() - (maxWidth - 3);
        }
	          if (offset <= 4) {
            return str.substring(0, maxWidth - 3) + "...";
        }
	          if (maxWidth < 7) {
            throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
        }
	          if ((offset + (maxWidth - 3)) < str.length()) {
            return "..." + abbreviate(str.substring(offset), maxWidth - 3);
        }
        return "..." + str.substring(str.length() - (maxWidth - 3));
    }

    // Difference
    //-----------------------------------------------------------------------
    /**
5459:     * <p>Compares two Strings, and returns the portion where they differ.
5460:     * (More precisely, return the remainder of the second String,
5461:     * starting from where it's different from the first.)</p>
5462:     *
5463:     * <p>For example,
5464:     * <code>difference("i am a machine", "i am a robot") -> "robot"</code>.</p>
5465:     *
5466:     * <pre>
5467:     * StringUtils.difference(null, null) = null
5468:     * StringUtils.difference("", "") = ""
5469:     * StringUtils.difference("", "abc") = "abc"
5470:     * StringUtils.difference("abc", "") = ""
5471:     * StringUtils.difference("abc", "abc") = ""
5472:     * StringUtils.difference("ab", "abxyz") = "xyz"
5473:     * StringUtils.difference("abcde", "abxyz") = "xyz"
5474:     * StringUtils.difference("abcde", "xyz") = "xyz"
5475:     * </pre>
5476:     *
5477:     * @param str1  the first String, may be null
5478:     * @param str2  the second String, may be null
5479:     * @return the portion of str2 where it differs from str1; returns the
5480:     * empty String if they are equal
5481:     * @since 2.0
5482:     */
    public static String difference(String str1, String str2) {
	          if (str1 == null) {
            return str2;
        }
	          if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
	          if (at == -1) {
            return EMPTY;
        }
        return str2.substring(at);
    }

    /**
5498:     * <p>Compares two Strings, and returns the index at which the
5499:     * Strings begin to differ.</p>
5500:     *
5501:     * <p>For example,
5502:     * <code>indexOfDifference("i am a machine", "i am a robot") -> 7</code></p>
5503:     *
5504:     * <pre>
5505:     * StringUtils.indexOfDifference(null, null) = -1
5506:     * StringUtils.indexOfDifference("", "") = -1
5507:     * StringUtils.indexOfDifference("", "abc") = 0
5508:     * StringUtils.indexOfDifference("abc", "") = 0
5509:     * StringUtils.indexOfDifference("abc", "abc") = -1
5510:     * StringUtils.indexOfDifference("ab", "abxyz") = 2
5511:     * StringUtils.indexOfDifference("abcde", "abxyz") = 2
5512:     * StringUtils.indexOfDifference("abcde", "xyz") = 0
5513:     * </pre>
5514:     *
5515:     * @param str1  the first String, may be null
5516:     * @param str2  the second String, may be null
5517:     * @return the index where str2 and str1 begin to differ; -1 if they are equal
5518:     * @since 2.0
5519:     */
     public static int indexOfDifference(String str1, String str2) {
	          if (str1 == str2) {
            return -1;
        }
	          if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
	          for (i = 0; i < str1.length() && i < str2.length(); ++i) {
	              if (str1.charAt(i) != str2.charAt(i)) {
               break;
            }
       }
          if (i < str2.length() || i < str1.length()) {
            return i;
       }
        return -1;
    }
    /**
//5540:     * <p>Compares all Strings in an array and returns the index at which the
5541:     * Strings begin to differ.</p>
5542:     *
5543:     * <p>For example,
5544:     * <code>indexOfDifference(new String[] {"i am a machine", "i am a robot"}) -> 7</code></p>
5545:     *
5546:     * <pre>
5547:     * StringUtils.indexOfDifference(null) = -1
5548:     * StringUtils.indexOfDifference(new String[] {}) = -1
5549:     * StringUtils.indexOfDifference(new String[] {"abc"}) = -1
5550:     * StringUtils.indexOfDifference(new String[] {null, null}) = -1
5551:     * StringUtils.indexOfDifference(new String[] {"", ""}) = -1
5552:     * StringUtils.indexOfDifference(new String[] {"", null}) = 0
5553:     * StringUtils.indexOfDifference(new String[] {"abc", null, null}) = 0
5554:     * StringUtils.indexOfDifference(new String[] {null, null, "abc"}) = 0
5555:     * StringUtils.indexOfDifference(new String[] {"", "abc"}) = 0
5556:     * StringUtils.indexOfDifference(new String[] {"abc", ""}) = 0
5557:     * StringUtils.indexOfDifference(new String[] {"abc", "abc"}) = -1
5558:     * StringUtils.indexOfDifference(new String[] {"abc", "a"}) = 1
5559:     * StringUtils.indexOfDifference(new String[] {"ab", "abxyz"}) = 2
5560:     * StringUtils.indexOfDifference(new String[] {"abcde", "abxyz"}) = 2
5561:     * StringUtils.indexOfDifference(new String[] {"abcde", "xyz"}) = 0
5562:     * StringUtils.indexOfDifference(new String[] {"xyz", "abcde"}) = 0
5563:     * StringUtils.indexOfDifference(new String[] {"i am a machine", "i am a robot"}) = 7
5564:     * </pre>
5565:     *
5566:     * @param strs  array of strings, entries may be null
5567:     * @return the index where the strings begin to differ; -1 if they are all equal
5568:     * @since 2.4
5569:     */
     public static int indexOfDifference(String[] strs) {
	          if (strs == null || strs.length <= 1) {
            return -1;
        }
        boolean anyStringNull = false;
        boolean allStringsNull = true;
        int arrayLen = strs.length;
        int shortestStrLen = Integer.MAX_VALUE;
        int longestStrLen = 0;

        // find the min and max string lengths; this avoids checking to make
        // sure we are not exceeding the length of the string each time through
        // the bottom loop.
	          for (int i = 0; i < arrayLen; i++) {
	              if (strs[i] == null) {
                anyStringNull = true;
                shortestStrLen = 0;
           } else {
               allStringsNull = false;
               shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
                longestStrLen = Math.max(strs[i].length(), longestStrLen);
           }
        }

        // handle lists containing all nulls or all empty strings
	          if (allStringsNull || (longestStrLen == 0 && !anyStringNull)) {
            return -1;
        }

        // handle lists containing some nulls or some empty strings
	          if (shortestStrLen == 0) {
            return 0;
        }

        // find the position with the first difference across all strings
        int firstDiff = -1;
	          for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
            char comparisonChar = strs[0].charAt(stringPos);
	              for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
	                  if (strs[arrayPos].charAt(stringPos) != comparisonChar) {
                    firstDiff = stringPos;
                    break;
                }
            }
	              if (firstDiff != -1) {
                break;
            }
       }

	          if (firstDiff == -1 && shortestStrLen != longestStrLen) {
            // we compared all of the characters up to the length of the
            // shortest string and didn't find a match, but the string lengths
            // vary, so return the length of the shortest string.
            return shortestStrLen;
        }
        return firstDiff;
    }
    
    /**
//5629:     * <p>Compares all Strings in an array and returns the initial sequence of 
5630:     * characters that is common to all of them.</p>
5631:     *
5632:     * <p>For example,
5633:     * <code>getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) -> "i am a "</code></p>
5634:     *
5635:     * <pre>
5636:     * StringUtils.getCommonPrefix(null) = ""
5637:     * StringUtils.getCommonPrefix(new String[] {}) = ""
5638:     * StringUtils.getCommonPrefix(new String[] {"abc"}) = "abc"
5639:     * StringUtils.getCommonPrefix(new String[] {null, null}) = ""
5640:     * StringUtils.getCommonPrefix(new String[] {"", ""}) = ""
5641:     * StringUtils.getCommonPrefix(new String[] {"", null}) = ""
5642:     * StringUtils.getCommonPrefix(new String[] {"abc", null, null}) = ""
5643:     * StringUtils.getCommonPrefix(new String[] {null, null, "abc"}) = ""
5644:     * StringUtils.getCommonPrefix(new String[] {"", "abc"}) = ""
5645:     * StringUtils.getCommonPrefix(new String[] {"abc", ""}) = ""
5646:     * StringUtils.getCommonPrefix(new String[] {"abc", "abc"}) = "abc"
5647:     * StringUtils.getCommonPrefix(new String[] {"abc", "a"}) = "a"
5648:     * StringUtils.getCommonPrefix(new String[] {"ab", "abxyz"}) = "ab"
5649:     * StringUtils.getCommonPrefix(new String[] {"abcde", "abxyz"}) = "ab"
5650:     * StringUtils.getCommonPrefix(new String[] {"abcde", "xyz"}) = ""
5651:     * StringUtils.getCommonPrefix(new String[] {"xyz", "abcde"}) = ""
5652:     * StringUtils.getCommonPrefix(new String[] {"i am a machine", "i am a robot"}) = "i am a "
5653:     * </pre>
5654:     *
5655:     * @param strs  array of String objects, entries may be null
5656:     * @return the initial sequence of characters that are common to all Strings
5657:     * in the array; empty String if the array is null, the elements are all null 
5658:     * or if there is no common prefix. 
5659:     * @since 2.4
5660:     */
    public static String getCommonPrefix(String[] strs) {
	          if (strs == null || strs.length == 0) {
            return EMPTY;
        }
        int smallestIndexOfDiff = indexOfDifference(strs);
	          if (smallestIndexOfDiff == -1) {
            // all strings were identical
	              if (strs[0] == null) {
                return EMPTY;
            }
            return strs[0];
        } else if (smallestIndexOfDiff == 0) {
            // there were no common initial characters
            return EMPTY;
        } else {
            // we found a common initial character sequence
            return strs[0].substring(0, smallestIndexOfDiff);
        }
    }  
    
    // Misc
    //-----------------------------------------------------------------------
    /**
5684:     * <p>Find the Levenshtein distance between two Strings.</p>
5685:     *
5686:     * <p>This is the number of changes needed to change one String into
5687:     * another, where each change is a single character modification (deletion,
5688:     * insertion or substitution).</p>
5689:     *
5690:     * <p>The previous implementation of the Levenshtein distance algorithm
5691:     * was from <a href="http://www.merriampark.com/ld.htm">http://www.merriampark.com/ld.htm</a></p>
5692:     *
5693:     * <p>Chas Emerick has written an implementation in Java, which avoids an OutOfMemoryError
5694:     * which can occur when my Java implementation is used with very large strings.<br>
5695:     * This implementation of the Levenshtein distance algorithm
5696:     * is from <a href="http://www.merriampark.com/ldjava.htm">http://www.merriampark.com/ldjava.htm</a></p>
5697:     *
5698:     * <pre>
5699:     * StringUtils.getLevenshteinDistance(null, *)             = IllegalArgumentException
5700:     * StringUtils.getLevenshteinDistance(*, null)             = IllegalArgumentException
5701:     * StringUtils.getLevenshteinDistance("","")               = 0
5702:     * StringUtils.getLevenshteinDistance("","a")              = 1
5703:     * StringUtils.getLevenshteinDistance("aaapppp", "")       = 7
5704:     * StringUtils.getLevenshteinDistance("frog", "fog")       = 1
5705:     * StringUtils.getLevenshteinDistance("fly", "ant")        = 3
5706:     * StringUtils.getLevenshteinDistance("elephant", "hippo") = 7
5707:     * StringUtils.getLevenshteinDistance("hippo", "elephant") = 7
5708:     * StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz") = 8
5709:     * StringUtils.getLevenshteinDistance("hello", "hallo")    = 1
5710:     * </pre>
5711:     *
5712:     * @param s  the first String, must not be null
5713:     * @param t  the second String, must not be null
5714:     * @return result distance
5715:     * @throws IllegalArgumentException if either String input <code>null</code>
5716:     */
       public static int getLevenshteinDistance(String s, String t) {
	          if (s == null || t == null) {
            throw new IllegalArgumentException("Strings must not be null");
            }

         int n = s.length(); // length of s
          int m = t.length(); // length of t

	          if (n == 0) {
            return m;
        } else if (m == 0) {
            return n;
        }

	          if (n > m) {
            // swap the input strings to consume less memory
            String tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        int p[] = new int[n+1]; //'previous' cost array, horizontally
        int d[] = new int[n+1]; // cost array, horizontally
        int _d[]; //placeholder to assist in swapping p and d

        // indexes into strings s and t
        int i; // iterates through s
        int j; // iterates through t

        char t_j; // jth character of t

        int cost; // cost

	          for (i = 0; i<=n; i++) {
            p[i] = i;
        }

	          for (j = 1; j<=m; j++) {
            t_j = t.charAt(j-1);
            d[0] = j;

	              for (i=1; i<=n; i++) {
                cost = s.charAt(i-1)==t_j ? 0 : 1;
                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                d[i] = Math.min(Math.min(d[i-1]+1, p[i]+1),  p[i-1]+cost);
            }

            // copy current distance counts to 'previous row' distance counts
            _d = p;
            p = d;
            d = _d;
        }
        // our last action in the above loop was to switch d and p, so p now 
        // actually has the most recent cost counts
        return p[n];
    }

    /**
5795:     * <p>Gets the minimum of three <code>int</code> values.</p>
5796:     *
5797:     * @param a  value 1
5798:     * @param b  value 2
5799:     * @param c  value 3
5800:     * @return  the smallest of the values
5801:     */
/*
5803:	      private static int min(int a, int b, int c) {
5804:        // Method copied from NumberUtils to avoid dependency on subpackage
5805:	          if (b < a) {
5806:            a = b;
5807:        }
5808:	          if (c < a) {
5809:            a = c;
5810:        }
5811:        return a;
5812:    }
5813:*/

    /**
5819:     * <p>Check if a String starts with a specified prefix.</p>
5820:     *
5821:     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
5822:     * references are considered to be equal. The comparison is case sensitive.</p>
5823:     *
5824:     * <pre>
5825:     * StringUtils.startsWith(null, null)      = true
5826:     * StringUtils.startsWith(null, "abcdef")  = false
5827:     * StringUtils.startsWith("abc", null)     = false
5828:     * StringUtils.startsWith("abc", "abcdef") = true
5829:     * StringUtils.startsWith("abc", "ABCDEF") = false
5830:     * </pre>
5831:     *
5832:     * @see java.lang.String#startsWith(String)
5833:     * @param str  the String to check, may be null
5834:     * @param prefix the prefix to find, may be null
5835:     * @return <code>true</code> if the String starts with the prefix, case sensitive, or
5836:     *  both <code>null</code>
5837:     * @since 2.4
5838:     */
    public static boolean startsWith(String str, String prefix) {
        return startsWith(str, prefix, false);
    }

    /**
5844:     * <p>Case insensitive check if a String starts with a specified prefix.</p>
5845:     *
5846:     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
5847:     * references are considered to be equal. The comparison is case insensitive.</p>
5848:     *
5849:     * <pre>
5850:     * StringUtils.startsWithIgnoreCase(null, null)      = true
5851:     * StringUtils.startsWithIgnoreCase(null, "abcdef")  = false
5852:     * StringUtils.startsWithIgnoreCase("abc", null)     = false
5853:     * StringUtils.startsWithIgnoreCase("abc", "abcdef") = true
5854:     * StringUtils.startsWithIgnoreCase("abc", "ABCDEF") = true
5855:     * </pre>
5856:     *
5857:     * @see java.lang.String#startsWith(String)
5858:     * @param str  the String to check, may be null
5859:     * @param prefix the prefix to find, may be null
5860:     * @return <code>true</code> if the String starts with the prefix, case insensitive, or
5861:     *  both <code>null</code>
5862:     * @since 2.4
5863:     */

public static boolean startsWithIgnoreCase(String str, String prefix) {
        return startsWith(str, prefix, true);
    }


private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
	          if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
	          if (prefix.length() > str.length()) {
            return false;
       }
       return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }


public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

public static boolean endsWithIgnoreCase(String str, String suffix) {
        return endsWith(str, suffix, true);
    }


private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
	          if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
	          if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
    }

    
    
    
}
