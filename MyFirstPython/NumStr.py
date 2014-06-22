# This is a comment line

def main():
    var = 5
    print(type(var), var)
    
    var = float(5)
    print(type(var), var)
    
    var = 5.0
    print(type(var), var)

    var = 22 / 9
    print(type(var), var)
    
    var = round(22 / 9, 3)
    print(type(var), var)

    var = 22 // 9
    print(type(var), var)

    var = 22 % 9
    print(type(var), var)
    
    s = "this is a string"
    print(type(s), s)
    
    s = 'this is a string also'
    print(type(s), s)

    s = 'this is a string also, \nnew line'
    print(type(s), s)
    
    s = r'this is a string also, \nnew line'
    print(type(s), s)

    s = r'this is a string with a number {}'.format(var)
    print(type(s), s)

if __name__ == "__main__": main()
