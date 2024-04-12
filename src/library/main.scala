package library

object main extends App {
  
  
  val exemple= Tag("html",List(),
                   List(Tag("head",List(),
                            List(Tag("meta",List(("content","text/html"),("charset","iso-8859-1")),List()),
                            		Tag("title",List(),List(Text("MyPage"))))),
                        Tag("body",List(),List(
                            Text("&nbsp"),
                            Tag("center",List(),List(
                            		Tag("a", List(("href","http://www.irisa.fr")),
                            				List(Text("irisa"),Tag("img",List(),List()))),
                            		Tag("a", List(("href","http://www.istic.fr")),
                            				List(Text("istic"),Tag("img",List(),List())))))))))
 

  val myExpression = ExpressionParser.readExp;
  println(AnalyserHtml.filtreHtml(exemple, myExpression))
  
  
      
  //val testAnd = And(Word("nantes"), Word("rennes"))
  //println(AnalyserHtml.filtreHtml(exemple,testAnd))
  
  //val testOr = Or(Word("rennes"), Word("nantes"))
  //println(AnalyserHtml.filtreHtml(exemple,testOr))

}