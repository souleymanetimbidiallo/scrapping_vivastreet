package library

object AnalyserHtml extends FiltrageHtml{
    /**
   * A partir d'un document Html h et d'une requête e, dit si le document
   * satisfait l'expression e
   *
   * @param h le document Html
   * @param e l'expression
   * @return true si le document satisfait l'expression e
   */
  def filtreHtml(h: Html, e: Expression): Boolean = {
    val str = html2String(h)
    contient(e, str)
  } 
   
  /**
   * A partir d'un document Html h, permet de recuperer la liste des mots
   *
   * @param h le document Html
   * @return une chaine de caractère contenant la liste des mots.
   */
   def html2String(h:Html):String = {
     var str = ""
     h match{
       case Text(mot) => mot
       case Tag(_,_,list) => 
         for(elem <- list){
           str = str + html2String(elem)
         }
         str
     }
   }
  
    
  /**
   * A partir d'une expression e et d'une chaine de caractère s, informe si l'expression e
   * contient la chaine s
   *
   * @param e l'expression
   * @param e l'expression
   * @return true si la chaine de caractères est inclut dans l'expression e
   */
   def contient(e:Expression, s:String): Boolean = {
    e match{
      case And(e1, e2) => contient(e1, s) && contient(e2, s)
      case Or(e1, e2) => contient(e1, s) || contient(e2, s)
      case Word(mot) => s.contains(mot)  
      }
    }
   
   def listKeyWords(e:Expression):List[String]={
     var list:List[String] = List()
     e match{
       case Word(mot) => list:+mot
       case And(e1, e2) => list:+listKeyWords(e1); list:+listKeyWords(e2)
       case Or(e1, e2) => list:+listKeyWords(e1); list:+listKeyWords(e2)
       
     }
     list
   }
}