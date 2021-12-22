#RLE: DDDD -> 4D; 1112222 -> 3 - 1, 4 - 2;
#alteracao estatistica, move-to-front
#
import numpy as np
import os
import func_aux as fa
import RLE as rl
import LZW as l
import burrows_wheeler as bw
import moveToFront as mtf
import huffman as hf
import shanon_fano as sf




def writeEntropy(source, forAlf, string):
    with open("entropy.txt", "a") as f:
        f.write("Entropy of "+string+" "+str(fa.entropia(source, fa.getAlpha(forAlf))))
        f.write("\n")

# Perform Run–length encoding (RLE) data compression algorithm on string `str`

def codeHuffman(fIn, fOut):
    inString = fa.readText(fIn)
    asArrayIn = np.array(list(inString))

    hold = hf.Huffman_Enconding(inString)
    s = hold[0]
    asArrayOut = np.array(list(s))
    tree = hold[1]
    np.save("huffmanArray", asArrayOut)
    with open(fOut, "w") as f:
        f.write(s)
    
    print(fa.entropia(asArrayIn, fa.getAlpha(asArrayIn)))
    print(fa.entropia(asArrayOut, fa.getAlpha(asArrayOut)))

    decoded = hf.Huffman_Decoding(s, tree)
    

    return decoded

def codeBWT(fIn, fOut):
    inString = fa.readText(fIn)
    asArrayIn = np.array(list(inString))
    print("AY")
    hold = bw.bwtencode(inString)   
    print("AY")
    asArrayOut = np.array(list(hold))

    np.save("arrayBwt", asArrayOut)
    print("AY")

    with open(fOut, "w") as f:
        f.write(hold)
    
    
        

def main():
    with open("entropy.txt", "w"):
        pass
    filesIn = ["dataset/bible.txt", "dataset/finance.csv", "dataset/jquery-3.6.0.js", "dataset/random.txt"]
    filesOut = ["dataset/bible1.txt", "dataset/finance1.csv", "dataset/jquery-3.6.0.1.js", "dataset/random1.txt"]

    methods = ["RUN_LENGTH_ENCODING"]
    for i in range(1):
        for n in range(len(methods)):
            fInput = "dataset/random.txt"
            fOutput = "dataset/random1.txt"
            input = fa.readText(fInput)

            #codeBWT(fInput, fOutput)
            #codeHuffman(fInput, fOutput)
            print("YO")
            #tree = sf.codeShannon(fInput, fOutput)
            tree = np.load("shannon_letter.npy", "r")
            sf.decodeShannon(fOutput, tree.tolist())

            # print("AY")
            # hold = np.load("decoded.txt.npy", "r")
            # print(hold)

            # decoded = codeHuffman(fInput, fOutput)
            # asArrayDecoded = np.array(list(decoded))

            # with open("decoded.txt", "w") as f1:
            #     f1.write(decoded)

            # print(fa.entropia(asArrayDecoded, fa.getAlpha(asArrayDecoded)))

            


if __name__ == '__main__':
    main()
    
    
#METHODS JUNCTION:
"""
RLE
LZW
BURROWS
MTF
HUFFMAN

BURROWS+RLE
BURROWS+LZW
BURROWS+MTF


"""