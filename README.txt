Qitong Sun
48927123
d4m8

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Compile Instruction
Run as a Java Application

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Important Note: 
I wrote the RunSQLScript class and use it as a parser for local SQL script file. 
It reads the file and send the statements into Oracle one by one. 
It is activated by you first run the program and make the selection. 
If you do that, the database will reset to initial value.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Question 1: 

ORIGINAL TABLE

a00001 50 100 y
a00002 60 500 y
a00003 64 200 n
a00004 800 500 y
a00005 56 130 n
a00006 66 300 n
a00007 123 320 y
a00008 100 125 y
a00009 99 159 n
a00010 76 123 y
a00011 88 144 n
a00012 50 264 y
a00013 74 155 y
a00014 24 160 y
a00015 15 8 n
a00016 10 6 y
a00017 34 5 n
a00018 1000 200 y
a00019 112 150 n
a00020 44 2 n
a00021 99 0 y

SUCCESSFUL ADD

Item successfully added.
a00001 50 100 y
a00002 60 500 y
a00003 64 200 n
a00004 800 500 y
a00005 56 130 n
a00006 66 300 n
a00007 123 320 y
a00008 100 125 y
a00009 99 159 n
a00010 76 123 y
a00011 88 144 n
a00012 50 264 y
a00013 74 155 y
a00014 24 160 y
a00015 15 8 n
a00016 10 6 y
a00017 34 5 n
a00018 1000 200 y
a00019 112 150 n
a00020 44 2 n
a00021 99 0 y
b00001 30 20 y

UNSUCCESSFUL ADD

Error: Item not added because of duplicate primary key 'a00002'.
a00001 50 100 y
a00002 60 500 y
a00003 64 200 n
a00004 800 500 y
a00005 56 130 n
a00006 66 300 n
a00007 123 320 y
a00008 100 125 y
a00009 99 159 n
a00010 76 123 y
a00011 88 144 n
a00012 50 264 y
a00013 74 155 y
a00014 24 160 y
a00015 15 8 n
a00016 10 6 y
a00017 34 5 n
a00018 1000 200 y
a00019 112 150 n
a00020 44 2 n
a00021 99 0 y
b00001 30 20 y

SUCCESSFUL DELETE

Item successfully deleted.
a00002 60 500 y
a00003 64 200 n
a00004 800 500 y
a00005 56 130 n
a00006 66 300 n
a00007 123 320 y
a00008 100 125 y
a00009 99 159 n
a00010 76 123 y
a00011 88 144 n
a00012 50 264 y
a00013 74 155 y
a00014 24 160 y
a00015 15 8 n
a00016 10 6 y
a00017 34 5 n
a00018 1000 200 y
a00019 112 150 n
a00020 44 2 n
a00021 99 0 y

UNSUCCESSFUL DELETE

Error: Item not deleted because the primary key 'a00001' is referenced by another table.
a00001 50 100 y
a00002 60 500 y
a00003 64 200 n
a00004 800 500 y
a00005 56 130 n
a00006 66 300 n
a00007 123 320 y
a00008 100 125 y
a00009 99 159 n
a00010 76 123 y
a00011 88 144 n
a00012 50 264 y
a00013 74 155 y
a00014 24 160 y
a00015 15 8 n
a00016 10 6 y
a00017 34 5 n
a00018 1000 200 y
a00019 112 150 n
a00020 44 2 n
a00021 99 0 y

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Question 2: 

History of Civilization
Microcontroller Programming
Introduction to Computational Neuroscience


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Question 3: 

a00021
a00020
a00017

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%