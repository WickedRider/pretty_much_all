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

'''
RLE:
    random.txt : IN:96767 OUT:187842    RLE ratio: -94.1%
    
'''

def writeEntropy(source, forAlf, string):
    with open("entropy.txt", "a") as f:
        f.write("Entropy of "+string+" "+str(fa.entropia(source, fa.getAlpha(forAlf))))
        f.write("\n")

# Perform Run–length encoding (RLE) data compression algorithm on string `str`

            

def main():
    with open("entropy.txt", "w"):
        pass
    filesIn = ["dataset/bible.txt", "dataset/finance.csv", "dataset/jquery-3.6.0.js", "dataset/random.txt"]
    filesOut = ["dataset/bible1.txt", "dataset/finance1.csv", "dataset/jquery-3.6.0.1.js", "dataset/random1.txt"]

    methods = ["RUN_LENGTH_ENCODING"]
    for i in range(1):
        for n in range(len(methods)):
            stri = filesIn[i]
            fileOut = filesOut[i]
            sure = fa.readText(stri)
            size1 = os.path.getsize(stri)
            print(stri+":\n"+"File size: "+str(size1))
        
            sure1 = rl.encode(sure)
        
            with open("entropy.txt", "a") as f:
                f.write(methods[n]+"\n")

            with open("decoded.txt", "w") as f1:
                f1.write(rl.decode(sure1))
                
            with open(fileOut, "w") as f:
                f.write(sure1)
            f.close()

            size2 = os.path.getsize(fileOut)
            print(fileOut+":\n"+"File size after compression: "+str(size2)) 
            
            sure1 = fa.readText(fileOut)
            a = size1 / size2
            print("Compress ratio (bits at input / bits at output): "+str(a))
            
            sureNP = np.asarray(sure)
            sure1NP = np.asarray(sure1)
            print("Entropia de "+stri+": "+str(fa.entropia(sureNP, fa.getAlpha(sure))))
            #writeEntropy(sureNP, fa.getAlpha(sure), stri)
            print("RUN_LENGTH_ENCODING: Entropia de "+fileOut+": "+str(fa.entropia(sure1NP, fa.getAlpha(sure1)))+"\n")
            #writeEntropy(sure1NP, fa.getAlpha(sure1), fileOut)
    
if __name__ == '__main__':
    main()