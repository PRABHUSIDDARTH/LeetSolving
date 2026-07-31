class Solution:
    def simplifyPath(self, path: str) -> str:
        path=path.split("/")
        path=[i for i in path if i!=""]
        print(path)
        l=[]
        for i in path:
            if i==".":
                continue
            if i!='..':
                l.append(i)
            else:
                if l:
                    l.pop()
                else:
                    continue
        
        a="/"+"/".join(map(str,l))
        
        print(a)
        return a