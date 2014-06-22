# This is a comment line

def main():
    var = (1, 2, 3, 4, 5)
    print(type(var), var)
    
    var = [1, 2, 3, 4, 5]
    var.append(6)
    var.index(1, 0)
    print(type(var), var)
    
    d = {'one':1, 'two':2, 'three':3}
    print(type(d), d)
    for k in d:
        print(k, d[k])
        
    d = dict(one=1, two=2, three=3)
    print(type(d), d)
    for k in d:
        print(k, d[k])

    s = 'str'
    print(type(s), s)
    
    a, b = 1, 2
    print(a, b)
    print(a == b)
    print(a < b)
    
    a = True
    print(type(a), a)
    
if __name__ == "__main__": main()
