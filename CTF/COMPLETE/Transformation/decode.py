enconded_string = "灩捯䍔䙻ㄶ形楴獟楮獴㌴摟潦弸弰摤捤㤷慽"
for i in range(len(enconded_string)):
    print(chr(ord(enconded_string[i])>>8), end="")
    print(chr((ord(enconded_string[i]))-((ord(enconded_string[i])>>8)<<8)), end="")
print(" ")