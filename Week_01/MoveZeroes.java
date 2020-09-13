class MoveZeroes {
    //类似于快慢指针
    //i为慢指针，来控制不为0的部分
    //j为快指针，发现j不为0，就将值赋给0的位置
    //直到j越界，i的位置就可以全赋值为0
    public void moveZeroes(int[] nums) {
        for (int i=0, j=0; i<nums.length; j++) {
            if (j >= nums.length) {
                nums[i++] = 0;
                continue;
            }

            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
    }
}