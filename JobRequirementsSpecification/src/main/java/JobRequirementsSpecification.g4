grammar JobRequirementsSpecification;

// Parser Rules
start: specification;

// Constitution of the Specification
specification: header requirements+;

// Template Header Components
header: title company_name description email;

title : TITLE DESCRIPTION NEWLINE;
company_name : COMPANY DESCRIPTION NEWLINE;
description : JOB DESCRIPTION NEWLINE;
email : EMAIL (DESCRIPTION | NUMBER)+  NEWLINE;

// Requirements
requirements: REQUIREMENT NUMBER NEWLINE question+;
question: (number | multiple | text )+ ;
number: NUMBERQ DESCRIPTION NEWLINE ANSEWER NUMBER NEWLINE;
multiple: MULTIPLEQ DESCRIPTION options+ NEWLINE ANSEWER MULTIPLANSEWER NEWLINE;
text: TEXTQ DESCRIPTION NEWLINE ANSEWER DESCRIPTION NEWLINE;
options: NEWLINE DESCRIPTION;


// Lexer Ruless
TITLE: 'TITLE: ';
COMPANY: 'COMPANY:';
JOB: 'ABOUT THIS JOB:';
EMAIL: 'EMAIL:';
REQUIREMENT: 'REQUIREMENT ';
NUMBERQ: 'NUMBER QUESTION:';
MULTIPLEQ: 'MULTIPLE MULTIPLE-CHOICE QUESTION:';
TEXTQ: 'TEXT QUESTION:';
ANSEWER: 'ANSWER:';

NUMBER: [0-9 ]+;

MULTIPLANSEWER: [a-d,) ]+;

NEWLINE: [\r\n]+;

DESCRIPTION: [a-zA-Z .?,()-+#@]+;