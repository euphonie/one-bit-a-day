from abc import ABC, abstractmethod
from datetime import datetime

class Entry(ABC):

    def __init__(self, name, parent_dir):
        self.name = name
        self.parent = parent_dir
        self.created = datetime.now()
        self.last_updated = datetime.now()
        self.last_accessed = datetime.now()
    
    def delete(self) -> bool:
        if self.parent == None:
            return False
        return self.parent.deleteEntry(self)
    
    @abstractmethod
    def size(self) -> int:
        pass
    
    def get_creation_time(self) -> datetime:
        return self.created
    
    def get_last_updated_time(self) -> datetime:
        return self.last_updated
    
    def get_last_accessed_time(self) -> datetime:
        return self.last_accessed
    
    def change_name(self, name) -> None:
        self.name = name
    
    def get_name(self) -> str:
        return self.name

class File(Entry):

    def __init__(self, name, parent_dir, size):
        super().__init__(name, parent_dir)
        self.size = size
        self.content = ""
    
    def size(self) -> int:
        return self.size
    
    def get_contents(self) -> str:
        return self.content
    
    def set_contents(self, c):
        self.content = c


class Directory(Entry):

    def __init__(self, name, parent_dir):
        super().__init__(name, parent_dir)
        self.contents = []
    
    def size(self):
        size = 0
        for e in self.contents:
            size += e.size()
        
        return size
    
    def number_of_files(self):
        count = 0
        for e in self.contents:
            if isinstance(e, Directory):
                count+= 1
                count += e.number_of_files
            elif isinstance(e, File):
                count+=1
        return count
    
    def delete_entry(self, entry):
        return self.contents.remove(entry)
    
    def add_entry(self, entry):
        self.contents.append(entry)
    
    def get_contents(self):
        return self.contents
