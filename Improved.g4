grammar Improved;

prog :  classDecl+
     ;

classDecl
        :   'class' ID '{' block '}'                               #classDeclaration
        ;
        



block
locals [
List<String> symbols = new ArrayList<String>()
]

: 
     varDecl*  statement*                                              
    ;
    
    
varDecl : type ID ';' 

          {
          if ($block::symbols.contains($ID.text)) {
          	  System.err.println("variable: "+$ID.text +" has already been defined!");
          } else {
                  $block::symbols.add($ID.text);
            }
          }                                                         #variableDeclaration     
        ;

        
        
type  :   'int'                                                    
      |   'int' '[' ']'                                             
      |   'boolean'                                                 
      ;
  
statement
         :   '{' statement* '}'                                      #statementRecall
         |   'System.out.println' '(' expr ')' ';'                   #statementPrint
         |   ID '=' expr ';'                                        
         {
            if ( !$block::symbols.contains($ID.text) ) {
                   System.err.println("undefined variable: "+$ID.text);
              }
          }                                                          #assign 
          | ID '=' '{'expr (',' expr)* '}' ';'                       #arrayAssign
         ;

expr
        :   expr op=( '+' | '-') expr                                  # addSub
        |   expr op=( '/' | '*') expr                                  # MulDiv
        |   expr op='%' expr                                           # mod                                          
        |   '(' expr ')'                                               # parens
        |   'fun' f=('Max'|'Min'|'Avg'|'Sort') '(' ID (',' ID)+ ')'    # functioncall
        |    expr op='^' expr                                           # Powe
        |   'sqrt' '(' expr ')'                                         #strtt    
        |   INT                                                        # int
        |   ID                                                         # id
        ;

MAX :  'Max';
MIN :  'Min';
AVG :  'Avg';
SORT:  'Sort';

MUL : '*' ;

ADD : '+' ;
SUB : '-' ;

DIV : '/' ;

MOD : '%' ;


ID        :   [a-zA-Z_][a-zA-Z0-9_]*;
INT       :   '0'..'9'+ ;
DOUBLE    :    [0-9] '.' [0-9];
BOOLEAN   :   ('true' | 'false') ;
WS        :   [ \t\r\n]+ -> skip ;
COMMENT   : '/*' .*? '*/' -> skip ;
LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip;
