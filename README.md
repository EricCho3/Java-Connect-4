# Java-Connect-4

A terminal-based Connect 4 game, originally written in 11th-grade computer science 
class. Game state is stored in a 2D array, with win-checking and board 
updates computed sequentially with loops.

Years later, I revisited this project as the starting point for comparing 
sequential software logic against parallel hardware design — see the 
[FPGA/Verilog version](https://github.com/EricCho3/FPGA-Based-Connect-4), which reimplements the same game using a 
bitboard and clock-synchronous parallel logic on a Nexys A7.
