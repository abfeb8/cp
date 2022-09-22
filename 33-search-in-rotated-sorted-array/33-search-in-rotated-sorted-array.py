class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        lo = 0
        hi = n-1
        mid = int()
        
        # finding the lowest element
        while (lo < hi):
            mid = (lo+hi)//2
            if(nums[mid] > nums[hi]):
                lo = mid+1
            else:
                hi = mid

        # list is roated about mid element
        rot = lo

        lo = 0
        hi = n-1
        while(lo <= hi):
            mid = (lo+hi)//2
            rmid = (mid+rot)%n
            if(nums[rmid] == target):
                return rmid
            elif(nums[rmid] < target):
                lo = mid+1
            else:
                hi = mid-1
        return -1