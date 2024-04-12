package library
import java.io.FileWriter
  
class Application {
   /** Lit la requete */
   val myExpression = ExpressionParser.readExp;
   
   
   /** Construit l’URL a passer au site de reference*/
   val listKeyWords = AnalyserHtml.listKeyWords(myExpression)
   var str = ""
   for(keyWord <- listKeyWords){
     str += "+" + keyWord
   }
   val URL:String = "https://search.vivastreet.com/annonces/fr?lb=new&search=1&start_field=1&keywords="+str+"&cat_1=&geosearch_text=&searchGeoId=";

  
   /** Obtenir la liste de couples resultats (Titre,URL) qui satisfont la requete*/
   val listCouples:List[(String, String)] = AnalyserPage.resultats(URL, myExpression)
   
   
   /** Obtenir le document Html rassemblant la liste de couples resultats */
   val docHTML = ProducterResult.resultat2html(listCouples)
   
   
   /** Obtenir la chaıne de caracteres correspondant au document Html precedent */
   val docString = ProducterHtml2String.process(docHTML)
   
   
   /** Ecrit le resultat dans un fichier. */
   val file= new FileWriter("listesURL.txt")
   try{
     file.write(docString)
    }finally file.close()
  
  
}
